package com.android.ljm.gate.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserInfoViewModel : ViewModel() {

    val userInfoLiveData = MutableLiveData<UserInfo>()

    fun setUserInfo(userInfo: UserInfo) {
        userInfoLiveData.value = userInfo
    }

}