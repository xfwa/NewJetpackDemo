package com.android.ljm.gate.lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LifecycleActivity : AppCompatActivity() {

    lateinit var  myObserver: MyObserver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        myObserver = MyObserver(this)
        lifecycle.addObserver(myObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.removeObserver(myObserver)
    }

}