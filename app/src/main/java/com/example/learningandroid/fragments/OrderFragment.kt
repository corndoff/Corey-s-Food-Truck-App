package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.learningandroid.ui.orderedlist.MainActivity
import com.example.learningandroid.R


class OrderFragment : Fragment(R.layout.fragment_order) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBurgers = view.findViewById<Button>(R.id.btnBurgers)
        val btnPizza = view.findViewById<Button>(R.id.btnPizza)
        val btnWings = view.findViewById<Button>(R.id.btnWings)
        val btnSalads = view.findViewById<Button>(R.id.btnSalads)
        val btnCart = view.findViewById<Button>(R.id.btnCart)
        val btnSeafood = view.findViewById<Button>(R.id.btnSeafood)


        val hamburgersFragment = HamburgersFragment()
        val pizzaFragment = PizzaFragment()
        val wingsFragment = WingsFragment()
        val saladsFragment = SaladsFragment()
        val seafoodFragment = PastaFragment()
        val cartFragment = CartFragment()

        btnBurgers.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, hamburgersFragment)
                commit()
            }
        }

        btnWings.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, wingsFragment)
                commit()
            }
        }

        btnSalads.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, saladsFragment)
                commit()
            }
        }

        btnSeafood.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, seafoodFragment)
                commit()
            }
        }

        btnPizza.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, pizzaFragment)
                commit()
            }
        }

        val cartAmount = (activity as MainActivity).getItemList().count()
        var cartButton = view.findViewById<Button>(R.id.btnCart)
        cartButton.text = "${cartAmount} item(s) in the cart"
        btnCart.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, cartFragment)
                commit()
            }
        }
    }

}