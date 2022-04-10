package com.example.monsterhuntermvapp.rest

import com.example.monsterhuntermvapp.model.MotionValues
import retrofit2.Response
import retrofit2.http.GET

interface MotionValuesAPI {

    @GET(MOTION_VALUE_PATH)
    suspend fun getMotionValues(): Response<MotionValues>

    companion object {
        const val BASE_URL = "https://mhw-db.com/"
        private const val MOTION_VALUE_PATH = "motion-values"
    }
}