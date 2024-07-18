package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App: Application() {

    lateinit var model: MainViewModel

    override fun onCreate() {
        super.onCreate()
        model = MainViewModel(LiveDataW.Base())
    }

}