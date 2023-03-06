package com.android.ljm.gate.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels

class TestActivity : AppCompatActivity() {

    private var i = 0

    private val testViewModel:TestViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        findViewById<TextView>(R.id.tv_content).text = testViewModel.i.toString()
    }

    fun addOneClick(view: View) {
        testViewModel.i++
        findViewById<TextView>(R.id.tv_content).text = testViewModel.i.toString()
    }
}