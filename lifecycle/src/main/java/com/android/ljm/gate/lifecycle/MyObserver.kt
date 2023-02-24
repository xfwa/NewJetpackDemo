package com.android.ljm.gate.lifecycle

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

private const val TAG = "MyObserver"

class MyObserver(val activity: LifecycleActivity) : DefaultLifecycleObserver {

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        Log.d(TAG, "onStart上: ")
        TestUtil.diSomething {
            Log.d(TAG, "onStart: ")
        }
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d(TAG, "onPause: ")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        activity.lifecycle.removeObserver(this)
        super.onDestroy(owner)
        Log.d(TAG, "onDestroy: ")

    }

}