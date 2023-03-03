package com.android.ljm.gate.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel

class ApplicationViewModel(application: Application) :AndroidViewModel(application){

    fun init(){
        getSdCardSize(getApplication())
    }

    fun getSdCardSize(context: Context){

    }

}