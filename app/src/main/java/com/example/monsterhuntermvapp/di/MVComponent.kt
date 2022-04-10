package com.example.monsterhuntermvapp.di

import com.example.monsterhuntermvapp.MainActivity
import com.example.monsterhuntermvapp.views.GreatSwordFrag
import com.example.monsterhuntermvapp.views.HomeFrag
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class
])
interface MVComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(homeFrag: HomeFrag)
    fun inject(greatSwordFrag: GreatSwordFrag)
}