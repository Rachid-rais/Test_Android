package com.album.albumapplication.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        const val TAG = "BaseApplication"
    }
}