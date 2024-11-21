package com.syntax.tweetsy

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Tweesy:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}