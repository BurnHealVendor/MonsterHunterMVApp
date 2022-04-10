package com.example.monsterhuntermvapp.utils

sealed class MotionValuesState {
    object LOADING : MotionValuesState()
    class SUCCESS<T>(val jokes: T) : MotionValuesState()
    class ERROR(val error: Throwable) : MotionValuesState()
}