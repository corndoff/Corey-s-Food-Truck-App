package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import com.example.learningandroid.R
import com.example.learningandroid.ui.orderedlist.MainActivity


class PastaFragment : Fragment(R.layout.fragment_pasta) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rgPastaDish = view.findViewById<RadioGroup>(R.id.rgPastaDish)
        val rbSpaghetti = view.findViewById<RadioButton>(R.id.rbSpaghetti)
        val rbFettucciniAlfredo = view.findViewById<RadioButton>(R.id.rbFettucciniAlfredo)
        val rbChickenParm = view.findViewById<RadioButton>(R.id.rbChickenParm)
        val rbLasagna = view.findViewById<RadioButton>(R.id.rbLasagna)
        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val tvPastaDescription = view.findViewById<TextView>(R.id.tvPastaDescription)

        rbSpaghetti.setOnClickListener {
            tvPastaDescription.text = "Item Description:\n\n" + getString(R.string.Spaghetti)
        }

        rbFettucciniAlfredo.setOnClickListener {
            tvPastaDescription.text = "Item Description:\n\n" + getString(R.string.FettucciniAlfredo)
        }

        rbChickenParm.setOnClickListener {
            tvPastaDescription.text = "Item Description:\n\n" + getString(R.string.ChickenParm)
        }

        rbLasagna.setOnClickListener {
            tvPastaDescription.text = "Item Description:\n\n" + getString(R.string.Lasagna)
        }

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