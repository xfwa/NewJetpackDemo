package com.android.ljm.gate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val sharedLiveData = MutableLiveData<Int>()

    fun setValue(value: Int) {
        sharedLiveData.value = value
    }

}