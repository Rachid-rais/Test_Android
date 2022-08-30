package com.album.albumapplication.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.album.albumapplication.data.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AlbumRepository
) : ViewModel() {
    private val _state: MutableLiveData<HomeViewState> = MutableLiveData()
    val state: LiveData<HomeViewState> = _state

    fun onEvent(action: HomeViewState) {
        when (action) {
            HomeViewState.EntryScreen -> {
                getContent()
            }
            else -> {}
        }
    }

    private fun getContent() {
        _state.postValue(HomeViewState.Loading)

        viewModelScope.launch {

            repository.getAlbumsLocal().collect { albums ->
                if (albums.isNullOrEmpty()) {
                    _state.postValue(HomeViewState.EmptyContent)
                } else {
                    _state.postValue(HomeViewState.Content(albums = albums))
                }
            }
        }
    }
}