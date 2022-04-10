package com.example.monsterhuntermvapp.di

import com.example.monsterhuntermvapp.MainActivity
import com.example.monsterhuntermvapp.views.HomeFrag
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class
])
interface MVComponent {

    fun inject(mainActivity: MainActivity)
}