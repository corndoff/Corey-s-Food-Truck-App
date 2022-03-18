package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.learningandroid.ui.orderedlist.MainActivity
import com.example.learningandroid.R


class WingsFragment : Fragment(R.layout.fragment_wings) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cartFragment = CartFragment()
        val orderFragment = OrderFragment()
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val rgAmount = view.findViewById<RadioGroup>(R.id.rgAmount)
        val rgWings = view.findViewById<RadioGroup>(R.id.rgWings)
        val rgSauce = view.findViewById<RadioGroup>(R.id.rgSauce)

        btnOrder.setOnClickListener {

            var wingAmount = view.findViewById<RadioButton>(rgAmount.checkedRadioButtonId)
            var wingType = view.findViewById<RadioButton>(rgWings.checkedRadioButtonId)
            var wingSauce = view.findViewById<RadioButton>(rgSauce.checkedRadioButtonId)
            val itemOrdered = "${wingAmount.text} \n${wingType.text} \n${wingSauce.text}"

            (activity as MainActivity).addItemToList(itemOrdered)
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, cartFragment)
                commit()
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