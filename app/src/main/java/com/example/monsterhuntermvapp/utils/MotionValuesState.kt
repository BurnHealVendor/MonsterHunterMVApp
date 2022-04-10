package com.example.monsterhuntermvapp.utils

sealed class MotionValuesState {
    object LOADING : MotionValuesState()
    class SUCCESS<T>(val motionValues: T) : MotionValuesState()
    class ERROR(val error: Throwable) : MotionValuesState()
}