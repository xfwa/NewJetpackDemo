package com.android.ljm.gate.databinding

import android.util.Log
import android.view.View

class MyHandlers {

    fun onClickFriend(view: View) {
        Log.d("xfwa", "onClickFriend: ")
    }

    fun checkBoxClick(view: View,isCheck:Boolean){
        Log.d("xfwa", "isCheck: $isCheck")
    }

}