package com.example.hobbie

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HobbieRoomApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}