package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.isVisible
import com.example.learningandroid.OrderedItemsAdapter
import com.example.learningandroid.ui.orderedlist.MainActivity
import com.example.learningandroid.R


class HamburgersFragment : Fragment(R.layout.fragment_hamburgers) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val rgMeat = view.findViewById<RadioGroup>(R.id.rgMeat)
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        val cbCheese = view.findViewById<CheckBox>(R.id.cbCheese)
        val cbOnion = view.findViewById<CheckBox>(R.id.cbOnion)
        val cbLettuce = view.findViewById<CheckBox>(R.id.cbLettuce)
        val rgCheese = view.findViewById<RadioGroup>(R.id.rgCheese)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val orderFragment = OrderFragment()
        val cartFragment = CartFragment()

        val adapter = OrderedItemsAdapter((activity as MainActivity).getItemList(), (activity as MainActivity))


        cbCheese.setOnClickListener{
            if(cbCheese.isChecked){
                rgCheese.isVisible = true
            }else{
                rgCheese.isVisible = false
            }
        }


        btnOrder.setOnClickListener{
            val meat = view.findViewById<RadioButton>(rgMeat.checkedRadioButtonId)
            val cheeseType = view.findViewById<RadioButton>(rgCheese.checkedRadioButtonId)
            val cheese = cbCheese.isChecked
            val onion = cbOnion.isChecked
            val lettuce = cbLettuce.isChecked
            val orderString = "${meat.text} Hamburger" +
                    (if(cheese) "\n${cheeseType.text} Cheese" else "\nNo cheese") +
                    (if(onion) "\nOnion" else "\nNo onion") +
                    (if(lettuce) "\nLettuce" else "\nNo lettuce")
            (activity as MainActivity).addItemToList(orderString)
            adapter.notifyDataSetChanged()

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