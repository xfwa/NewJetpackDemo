package com.android.ljm.gate.viewmodel

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

class BlankFragmentA : Fragment() {

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_blank_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.sharedLiveData.observe(requireActivity()) {
            view.findViewById<TextView>(R.id.tv_value).text = "当前值：$it"
        }
        view.findViewById<Button>(R.id.btn_add_one).setOnClickListener {
            val value = viewModel.sharedLiveData.value ?: 0
            viewModel.setValue(value + 1)
        }
    }

}