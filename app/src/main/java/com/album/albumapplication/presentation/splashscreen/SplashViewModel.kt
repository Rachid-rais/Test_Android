package com.album.albumapplication.presentation.splashscreen

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.album.albumapplication.domain.BaseRepository
import com.album.albumapplication.utils.Constants
import com.album.albumapplication.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.album.albumapplication.data.remote.model.Result
import com.album.albumapplication.utils.PreferenceHelper.get
import com.album.albumapplication.utils.PreferenceHelper.set
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: BaseRepository,
    private val albumPrefs: SharedPreferences
) : ViewModel() {
    private val _state: MutableLiveData<SplashScreenViewState> = MutableLiveData()
    val state: LiveData<SplashScreenViewState> = _state

    fun isFirstLaunch(ctx: Context) {
        val appFirstTime = isAlbumLoaded()
        if (NetworkUtils.hasInternetConnection(ctx)) {
            loadAlbum(ctx)
        }else if(appFirstTime){
            // Play animation and going Home.
            _state.postValue(SplashScreenViewState.ContentAlreadyLoaded)
        }else
            _state.postValue(SplashScreenViewState.NoInternet)

    }

    @VisibleForTesting
    fun loadAlbum(ctx: Context) {
        viewModelScope.launch {
            val apiAlbum = repository.getAlbumListNetwork()
            when (apiAlbum.status) {
                Result.Status.SUCCESS -> {
                    // Saving datas into dataBase and going Home.
                    if (apiAlbum.data != null) {
                       // saveAlbumList(apiAlbum.data)
                    }
                }
                Result.Status.ERROR -> {
                    // Retry laod configuation
                    _state.postValue(SplashScreenViewState.Error)
                }
                Result.Status.LOADING -> {

                }
                else -> {}
            }

        }
    }

    private fun isAlbumLoaded(): Boolean {
        return albumPrefs[Constants.ALBUM_PREF_NAME, false] ?: false
    }

    private fun saveAlbumLoaded() {
        albumPrefs[Constants.ALBUM_PREF_NAME] = true
    }

}