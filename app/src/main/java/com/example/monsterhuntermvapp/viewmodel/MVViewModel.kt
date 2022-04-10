package com.example.monsterhuntermvapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import com.example.monsterhuntermvapp.utils.MotionValuesState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MVViewModel @Inject constructor(
    private val motionValuesRepo: MotionValuesRepo,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _motionValuesLiveData: MutableLiveData<MotionValuesState> = MutableLiveData(MotionValuesState.LOADING)
    val motionValuesLiveData: LiveData<MotionValuesState> get() = _motionValuesLiveData

    fun getMotionValues() {
        _motionValuesLiveData.postValue(MotionValuesState.LOADING)

        viewModelScope.launch(ioDispatcher) {
            try {
                val response = motionValuesRepo.getMotionValues()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _motionValuesLiveData.postValue(MotionValuesState.SUCCESS(it))
                    } ?: throw Exception("Response is null")
                }
                else {
                    throw Exception("No successful response")
                }
            }
            catch (e: Exception) {
                _motionValuesLiveData.postValue(MotionValuesState.ERROR(e))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("JokesViewModel", "ViewModel destroyed")
    }
}