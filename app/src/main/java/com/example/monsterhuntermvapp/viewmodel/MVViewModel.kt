package com.example.monsterhuntermvapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import com.example.monsterhuntermvapp.utils.MotionValuesState
import com.example.monsterhuntermvapp.utils.WeaponType
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
    var weaponType: WeaponType = WeaponType.GREAT_SWORD

    fun getMotionValues() {

        viewModelScope.launch(ioDispatcher) {
                val response = motionValuesRepo.getMotionValues(weaponType)
                    response.body()?.let {
                        _motionValuesLiveData.postValue(MotionValuesState.SUCCESS(it))
                    } ?: throw Exception("Response is null")
                }
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("MVViewModel", "ViewModel destroyed")
    }
}