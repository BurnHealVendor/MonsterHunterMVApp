package com.example.monsterhuntermvapp.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import com.example.monsterhuntermvapp.viewmodel.MVViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(
    private val applicationContext: Context
) {

    @Provides
    fun providesContext(): Context {
        return applicationContext
    }

    @Provides
    @Singleton
    fun providesMotionValuesViewModelFactory(motionValuesRepo: MotionValuesRepo): ViewModelProvider.Factory =
        MVViewModelFactory(motionValuesRepo)
}