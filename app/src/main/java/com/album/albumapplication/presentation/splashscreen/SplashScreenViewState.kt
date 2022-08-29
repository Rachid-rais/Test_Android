package com.album.albumapplication.presentation.splashscreen

sealed class SplashScreenViewState {

    object ContentAlreadyLoaded : SplashScreenViewState()
    object ContentLoaded : SplashScreenViewState()
    object Error : SplashScreenViewState()
    object NoInternet : SplashScreenViewState()
}