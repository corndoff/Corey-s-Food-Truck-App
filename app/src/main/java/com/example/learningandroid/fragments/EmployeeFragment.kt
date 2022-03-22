package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.learningandroid.R


class EmployeeFragment : Fragment(R.layout.fragment_employee) {

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

        val btnServer = view.findViewById<Button>(R.id.btnServer)
        val btnCook= view.findViewById<Button>(R.id.btnCook)
        val finishedOrdersFragment = FinishedOrdersFragment()
        val placedOrdersFragment = PlacedOrdersFragment()

        btnCook.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, placedOrdersFragment)
                commit()
            }
        }

        btnServer.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, finishedOrdersFragment)
                commit()
            }
        }
    }

}