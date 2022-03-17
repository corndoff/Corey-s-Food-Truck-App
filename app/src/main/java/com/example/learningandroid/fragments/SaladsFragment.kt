package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.learningandroid.ui.orderedlist.MainActivity
import com.example.learningandroid.R


class SaladsFragment : Fragment(R.layout.fragment_salads) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rgSaladGreen = view.findViewById<RadioGroup>(R.id.rgSaladGreen)
        val rgDressing = view.findViewById<RadioGroup>(R.id.rgDressing)
        val cbNoMeat = view.findViewById<CheckBox>(R.id.cbNoMeat)
        val cbHam = view.findViewById<CheckBox>(R.id.cbHam)
        val cbTurkey = view.findViewById<CheckBox>(R.id.cbTurkey)
        val cbRoastBeef = view.findViewById<CheckBox>(R.id.cbRoastBeef)
        val cbCarrots = view.findViewById<CheckBox>(R.id.cbCarrots)
        val cbMushroom = view.findViewById<CheckBox>(R.id.cbMushroom)
        val cbCranberries = view.findViewById<CheckBox>(R.id.cbCranberries)
        val cbCucumbers = view.findViewById<CheckBox>(R.id.cbCucumbers)
        val cbCheese = view.findViewById<CheckBox>(R.id.cbCheese)
        val cbWalnuts = view.findViewById<CheckBox>(R.id.cbWalnuts)
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val orderFragment = OrderFragment()
        val cartFragment = CartFragment()

        cbHam.setOnClickListener {
            if(cbHam.isChecked || cbTurkey.isChecked || cbRoastBeef.isChecked ){
                cbNoMeat.isChecked = false
            }
        }

        cbTurkey.setOnClickListener {
            if(cbHam.isChecked || cbTurkey.isChecked || cbRoastBeef.isChecked ){
                cbNoMeat.isChecked = false
            }
        }

        cbRoastBeef.setOnClickListener {
            if(cbHam.isChecked || cbTurkey.isChecked || cbRoastBeef.isChecked ){
                cbNoMeat.isChecked = false
            }
        }

        cbNoMeat.setOnClickListener {
            if(cbHam.isChecked || cbTurkey.isChecked || cbRoastBeef.isChecked ){
                cbNoMeat.isChecked = false
            }
        }

        btnOrder.setOnClickListener {
            val green = view.findViewById<RadioButton>(rgSaladGreen.checkedRadioButtonId)
            val dressing = view.findViewById<RadioButton>(rgDressing.checkedRadioButtonId)
            val noMeat = cbNoMeat.isChecked
            val ham = cbHam.isChecked
            val turkey = cbTurkey.isChecked
            val roastbeef = cbRoastBeef.isChecked
            val carrots = cbCarrots.isChecked
            val cheese = cbCheese.isChecked
            val cranberry = cbCranberries.isChecked
            val cucumber = cbCucumbers.isChecked
            val mushroom = cbMushroom.isChecked
            val walnut = cbWalnuts.isChecked
            val itemOrdered = "Salad with ${green.text}\n" +
                    (if(noMeat) "No Meat\n" else {
                        (if(ham) "Ham\n" else "") +
                                (if(turkey) "Turkey\n" else "") +
                                (if(roastbeef) "Roast Beef\n" else "")
                    } + (if(carrots) "Carrots\n" else "") +
                            (if(cheese) "Cheese\n" else "") +
                            (if(cranberry) "Cranberry\n" else "") +
                            (if(cucumber) "Cucumber\n" else "") +
                            (if(mushroom) "Mushroom\n" else "") +
                            (if(walnut) "Walnuts\n" else "") +
                        "${dressing.text} dressing")
            (activity as MainActivity).addItemToList(itemOrdered)

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, cartFragment)
                commit()
            }
        }

        btnBack.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, orderFragment)
            }
        }

    }
}