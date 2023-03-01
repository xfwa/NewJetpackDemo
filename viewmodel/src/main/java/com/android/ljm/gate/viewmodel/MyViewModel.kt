package com.android.ljm.gate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    val userNameLiveData = MutableLiveData<UserInfo>()

    fun getUserInfo() {
        userNameLiveData.value = UserInfo("张三", "18")
    }

}