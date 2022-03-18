package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.learningandroid.R
import com.example.learningandroid.ui.orderedlist.MainActivity


class PastaFragment : Fragment(R.layout.fragment_pasta) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rgPastaDish = view.findViewById<RadioGroup>(R.id.rgPastaDish)
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        val btnBack = view.findViewById<Button>(R.id.btnBack)

        val orderFragment = OrderFragment()
        val cartFragment = CartFragment()

        btnOrder.setOnClickListener {
            val pastaDish = view.findViewById<RadioButton>(rgPastaDish.checkedRadioButtonId)
            if(pastaDish == null){
                Toast.makeText((activity as MainActivity), "Please select a pasta dish", Toast.LENGTH_LONG).show()
            }else{
                    val itemOrdered = pastaDish.text.toString()
                (activity as MainActivity).addItemToList(itemOrdered)
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, cartFragment)
                    commit()
                }
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