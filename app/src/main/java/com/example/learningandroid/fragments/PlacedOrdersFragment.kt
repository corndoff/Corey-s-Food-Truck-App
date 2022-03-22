package com.example.learningandroid.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroid.OrderedItemsAdapter
import com.example.learningandroid.PlacedOrdersAdapter
import com.example.learningandroid.R
import com.example.learningandroid.data.db.FinishedFoodDatabase
import com.example.learningandroid.data.db.OrderedFoodDatabase
import com.example.learningandroid.data.db.entity.OrderedItems
import com.example.learningandroid.data.repositories.FinishedRepository
import com.example.learningandroid.data.repositories.OrderRepository
import com.example.learningandroid.ui.orderedlist.*
import kotlinx.android.synthetic.main.fragment_cart.*


class PlacedOrdersFragment : Fragment(R.layout.fragment_placed_orders) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orderedDatabase = OrderedFoodDatabase(activity as MainActivity)
        val orderedRepository = OrderRepository(orderedDatabase)
        val orderedFactory = OrderedViewModelFactory(orderedRepository)

        val finishedDatabase = FinishedFoodDatabase(activity as MainActivity)
        val finishedRepository = FinishedRepository(finishedDatabase)
        val finishedFactory = FinishedViewModelFactory(finishedRepository)

        val finishedViewModel = ViewModelProvider(this, finishedFactory).get(FinishedViewModel::class.java)
        val orderedViewModel = ViewModelProvider(this, orderedFactory).get(OrderedViewModel::class.java)

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val employeeFragment = EmployeeFragment()
        val rvItems = view.findViewById<RecyclerView>(R.id.rvItems)
        val adapter = PlacedOrdersAdapter(listOf(), orderedViewModel, finishedViewModel)
        rvItems.layoutManager = LinearLayoutManager(activity as MainActivity)
        rvItems.adapter = adapter

        orderedViewModel.getAllOrderedItems().observe(viewLifecycleOwner, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()

        })

        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, employeeFragment)
                commit()
            }
        }
    }
}