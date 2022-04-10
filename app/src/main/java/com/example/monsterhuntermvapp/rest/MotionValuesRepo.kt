package com.example.monsterhuntermvapp.rest

import com.example.monsterhuntermvapp.model.MotionValues
import retrofit2.Response

interface MotionValuesRepo {
    suspend fun getMotionValues(): Response<MotionValues>
}

class MotionValuesRepoImpl(
    private val motionValuesAPI: MotionValuesAPI
) : MotionValuesRepo {

    override suspend fun getMotionValues(): Response<MotionValues> =
        motionValuesAPI.getMotionValues()
}