package com.android.ljm.gate.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myLocationListener = MyLocationListener(this) {
            //回调
        }
    }

    override fun onStart() {
        super.onStart()
        TestUtil.diSomething {
            //因为这边耗时比较长，在activity停止后才回调
            //又因为myLocationListener持有Activity，所以会造成内存泄露
            myLocationListener.start()
        }
    }

    override fun onPause() {
        super.onPause()
        myLocationListener.stop()
    }

}