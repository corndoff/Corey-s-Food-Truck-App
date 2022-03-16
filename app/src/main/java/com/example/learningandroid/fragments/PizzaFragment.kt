package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.isVisible
import com.example.learningandroid.MainActivity
import com.example.learningandroid.R


class PizzaFragment : Fragment(R.layout.fragment_pizza) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var rgCrust = view.findViewById<RadioGroup>(R.id.rgCrust)
        var rgSauce = view.findViewById<RadioGroup>(R.id.rgSauce)
        var cbPepperoni = view.findViewById<CheckBox>(R.id.cbPepperoni)
        var cbBananaPepper = view.findViewById<CheckBox>(R.id.cbBananaPepper)
        var cbOnion = view.findViewById<CheckBox>(R.id.cbOnion)
        var cbHam = view.findViewById<CheckBox>(R.id.cbHam)
        var cbGarlic = view.findViewById<CheckBox>(R.id.cbGarlic)
        var cbGreenPepper = view.findViewById<CheckBox>(R.id.cbGreenPepper)
        var cbJalapeno = view.findViewById<CheckBox>(R.id.cbJalapeno)
        var cbChicken = view.findViewById<CheckBox>(R.id.cbChicken)
        var cbBlackOlives = view.findViewById<CheckBox>(R.id.cbBlackOlives)
        var cbMushroom = view.findViewById<CheckBox>(R.id.cbMushroom)
        var cbPineapple = view.findViewById<CheckBox>(R.id.cbPineapple)
        var cbSpinach = view.findViewById<CheckBox>(R.id.cbSpinach)
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val cartFragment = CartFragment()
        val orderFragment = OrderFragment()

        btnOrder.setOnClickListener {
            val crust = view.findViewById<RadioButton>(rgCrust.checkedRadioButtonId)
            val sauce = view.findViewById<RadioButton>(rgSauce.checkedRadioButtonId)
            val itemOrdered = "${crust.text} \n${sauce.text} \n" +
                    (if(cbPepperoni.isChecked) "Pepperoni\n" else "") +
                    (if(cbBananaPepper.isChecked) "Banana Pepper\n" else "") +
                    (if(cbOnion.isChecked) "Onion\n" else "") +
                    (if(cbHam.isChecked) "Ham\n" else "") +
                    (if(cbGarlic.isChecked) "Garlic\n" else "") +
                    (if(cbGreenPepper.isChecked) "Green Pepper\n" else "") +
                    (if(cbJalapeno.isChecked) "Jalapeno\n" else "") +
                    (if(cbChicken.isChecked) "Chicken\n" else "") +
                    (if(cbBlackOlives.isChecked) "Black Olives\n" else "") +
                    (if(cbMushroom.isChecked) "Mushroom\n" else "") +
                    (if(cbPineapple.isChecked) "Pineapple\n" else "") +
                    (if(cbSpinach.isChecked) "Spinach" else "")

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