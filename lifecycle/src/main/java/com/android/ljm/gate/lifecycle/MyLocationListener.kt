package com.android.ljm.gate.lifecycle

import android.content.Context
import android.util.Log

private const val TAG = "MyLocationListener"

/**
 * 这是平常的写法
 */
class MyLocationListener(context: Context, callback: () -> Unit) {

    fun start() {
        Log.d(TAG, "start todo: ")
    }

    fun stop() {
        Log.d(TAG, "stop todo: ")
    }

}