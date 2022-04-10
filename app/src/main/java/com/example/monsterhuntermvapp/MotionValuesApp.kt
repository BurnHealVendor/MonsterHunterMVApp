package com.example.monsterhuntermvapp

import android.app.Application
import com.example.monsterhuntermvapp.di.ApplicationModule
import com.example.monsterhuntermvapp.di.DaggerMVComponent
import com.example.monsterhuntermvapp.di.MVComponent

class MotionValuesApp : Application() {
    override fun onCreate() {
        super.onCreate()

        mvComponent = DaggerMVComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    companion object {
        lateinit var mvComponent: MVComponent
    }
}