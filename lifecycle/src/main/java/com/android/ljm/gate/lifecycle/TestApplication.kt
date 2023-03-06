package com.android.ljm.gate.lifecycle

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner

class TestApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }

}