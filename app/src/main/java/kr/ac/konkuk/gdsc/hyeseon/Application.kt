package kr.ac.konkuk.gdsc.hyeseon

import dagger.hilt.android.HiltAndroidApp
import android.app.Application

@HiltAndroidApp
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}