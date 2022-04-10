package com.example.monsterhuntermvapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import javax.inject.Inject

class MVViewModelFactory @Inject constructor(
    private val motionValuesRepo: MotionValuesRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MVViewModel(motionValuesRepo) as T
    }
}