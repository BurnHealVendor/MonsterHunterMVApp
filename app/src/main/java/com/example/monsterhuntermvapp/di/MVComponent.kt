package com.example.monsterhuntermvapp.di

import com.example.monsterhuntermvapp.MainActivity
import com.example.monsterhuntermvapp.views.*
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    NetworkModule::class
])
interface MVComponent {
    fun inject(homeFrag: HomeFrag)
    fun inject(greatSwordFrag: GreatSwordFrag)
    fun inject(longSwordFrag: LongSwordFrag)
    fun inject(swordAndShieldFrag: SwordAndShieldFrag)
    fun inject(dualBladesFrag: DualBladesFrag)
    fun inject(hammerFrag: HammerFrag)
    fun inject(huntingHornFrag: HuntingHornFrag)
    fun inject(lanceFrag: LanceFrag)
    fun inject(gunlanceFrag: GunlanceFrag)
    fun inject(switchAxeFrag: SwitchAxeFrag)
    fun inject(chargeBladeFrag: ChargeBladeFrag)
    fun inject(insectGlaiveFrag: InsectGlaiveFrag)
    fun inject(lightBowgunFrag: LightBowgunFrag)
    fun inject(heavyBowgunFrag: HeavyBowgunFrag)
    fun inject(bowFrag: BowFrag)
}