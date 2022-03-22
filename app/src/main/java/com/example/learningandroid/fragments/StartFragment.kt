package com.example.learningandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.learningandroid.R
import com.example.learningandroid.ui.orderedlist.CheckEmployeeId
import com.example.learningandroid.ui.orderedlist.MainActivity


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

        val btnCustomer = view.findViewById<Button>(R.id.btnCustomer)
        val btnEmployee= view.findViewById<Button>(R.id.btnEmployee)
        val orderFragment = OrderFragment()

        btnEmployee.setOnClickListener {
            val checkEmployeeId = CheckEmployeeId(activity as MainActivity)
            checkEmployeeId.show(parentFragmentManager, "Check Employee Id")
        }

        btnCustomer.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, orderFragment)
                commit()
            }
        }
    }

}