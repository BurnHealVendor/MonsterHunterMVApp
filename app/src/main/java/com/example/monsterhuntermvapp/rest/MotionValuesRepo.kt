package com.example.monsterhuntermvapp.rest

import com.example.monsterhuntermvapp.model.MotionValuesItem
import com.example.monsterhuntermvapp.utils.WeaponType
import retrofit2.Response

interface MotionValuesRepo {
    suspend fun getMotionValues(weaponType: WeaponType): Response<List<MotionValuesItem>>
}

class MotionValuesRepoImpl(
    private val motionValuesAPI: MotionValuesAPI
) : MotionValuesRepo {

    override suspend fun getMotionValues(weaponType: WeaponType): Response<List<MotionValuesItem>> =
        motionValuesAPI.getMotionValues(weaponType.realValue)
}