package com.example.monsterhuntermvapp.rest

import com.example.monsterhuntermvapp.model.MotionValuesItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MotionValuesAPI {

    @GET(MOTION_VALUE_PATH)
    suspend fun getMotionValues(
        @Query("weapon-type") weaponType: String
    ): Response<List<MotionValuesItem>>

    companion object {
        const val BASE_URL = "https://mhw-db.com/"
        private const val MOTION_VALUE_PATH = "motion-values"
    }
}