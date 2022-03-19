package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.learningandroid.R


class StartFragment : Fragment(R.layout.fragment_start) {

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

        val btnOrder = view.findViewById<Button>(R.id.btnOrder)
        val btnSeeOrders= view.findViewById<Button>(R.id.btnSeeOrders)
        val orderFragment = OrderFragment()
        val placedOrdersFragment = PlacedOrdersFragment()

        btnOrder.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, orderFragment)
                commit()
            }
        }

        btnSeeOrders.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, placedOrdersFragment)
                commit()
            }
        }
    }

}