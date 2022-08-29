package com.album.albumapplication.presentation.splashscreen

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.album.albumapplication.R
import com.album.albumapplication.databinding.ActivitySplashscreenBinding
import com.album.albumapplication.presentation.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashscreenBinding

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
        setUpObservers()
        loadListNetwork()
    }

    private fun setUpObservers() {
        splashViewModel.state.observe(this) {
            render(it)
        }
    }

    private fun render(splashScreenViewState: SplashScreenViewState?) {
        when (splashScreenViewState) {
            SplashScreenViewState.ContentLoaded -> {
                openHomeActivity()
            }
            SplashScreenViewState.Error -> {
                // TODO: Error Datas Message, with retry
            }
            SplashScreenViewState.NoInternet -> {
                Toast.makeText(applicationContext,resources.getString(R.string.error_verify_connection_internet), Toast.LENGTH_LONG).show()
            }
            SplashScreenViewState.ContentAlreadyLoaded -> {
                Handler(Looper.getMainLooper()).postDelayed(
                    {
                        // This method will be executed once the timer is over
                        openHomeActivity()
                    },
                    2000 // value in milliseconds
                )
            }
            else -> {
                // TODO: Error Datas Message, with retry
            }
        }
    }
    private fun loadListNetwork() {
        splashViewModel.isFirstLaunch(this@SplashActivity)
    }

    private fun openHomeActivity() {
        HomeActivity.open(this)
        finish()
    }

}