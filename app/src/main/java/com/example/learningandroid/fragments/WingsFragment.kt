package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.isVisible
import com.example.learningandroid.R


class WingsFragment : Fragment(R.layout.fragment_wings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orderFragment = OrderFragment()
        val startFragment = StartFragment()
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val rgAmount = view.findViewById<RadioGroup>(R.id.rgAmount)
        val rgWings = view.findViewById<RadioGroup>(R.id.rgWings)
        val rgSauce = view.findViewById<RadioGroup>(R.id.rgSauce)

        btnOrder.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, orderFragment)
                commit()
            }
        }

        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, startFragment)
                commit()
            }
        }
    }
}