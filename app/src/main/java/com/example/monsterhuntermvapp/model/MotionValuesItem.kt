package com.example.monsterhuntermvapp.model


import com.google.gson.annotations.SerializedName

data class MotionValuesItem(
    @SerializedName("damageType")
    val damageType: String,
    @SerializedName("exhaust")
    val exhaust: Int,
    @SerializedName("hits")
    val hits: List<Int>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("stun")
    val stun: Int,
    @SerializedName("weaponType")
    val weaponType: String
)