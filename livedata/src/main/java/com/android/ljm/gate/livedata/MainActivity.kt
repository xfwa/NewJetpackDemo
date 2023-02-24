package com.android.ljm.gate.livedata

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private val testLiveData = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testLiveData.observe(this) {
            Log.d(TAG, "liveData收到数据: $it")
        }
    }

    fun sendData(view: View) {
        testLiveData.value = "主线程发送数据"
    }

    fun postSendData(view: View) {
        lifecycleScope.launch(Dispatchers.IO) {
            testLiveData.postValue("子线程发送数据")
        }
    }

    fun mapOperator(view: View) {

    }

    fun switchOperator(view: View) {}
}