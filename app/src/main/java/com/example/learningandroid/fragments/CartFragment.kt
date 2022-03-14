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


class CartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val btnPlaceOrder = view.findViewById<Button>(R.id.btnPlaceOrder)
        val startFragment = StartFragment()
        val orderFragment = OrderFragment()


        btnPlaceOrder.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, startFragment)
            }
        }

        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, orderFragment)
                commit()
            }
        }
    }
}