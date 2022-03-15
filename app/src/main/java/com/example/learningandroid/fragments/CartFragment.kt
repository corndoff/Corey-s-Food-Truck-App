package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import com.example.learningandroid.MainActivity
import com.example.learningandroid.R
import java.io.Serializable


class CartFragment : Fragment(R.layout.fragment_cart) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val btnPlaceOrder = view.findViewById<Button>(R.id.btnPlaceOrder)
        val startFragment = StartFragment()
        val orderFragment = OrderFragment()
        val svItems = view.findViewById<ListView>(R.id.svItems)
        val tvItem = view.findViewById<TextView>(R.id.tvItems)
        var items = (activity as MainActivity).getItemList()
        val newitem:List<String> = mutableListOf(
            "isjsnfgowngowingoiwen",
            "oasngoinfgpimwrpgkmwprgkm",
            "ijsngijrngiorng"
        )
        val adapter = ArrayAdapter((context as MainActivity), R.layout.fragment_cart, newitem)
        svItems.adapter = adapter


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