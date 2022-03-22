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
import com.example.learningandroid.FinishedOrdersAdapter
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


class FinishedOrdersFragment : Fragment(R.layout.fragment_finished_orders) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = FinishedFoodDatabase(activity as MainActivity  )
        val repository = FinishedRepository(database)
        val factory = FinishedViewModelFactory(repository)

        val finishedViewModel = ViewModelProvider(this, factory).get(FinishedViewModel::class.java)
        //val orderedViewModel = ViewModelProvider(this, factory).get(OrderedViewModel::class.java)

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val startFragment = StartFragment()
        val rvItems = view.findViewById<RecyclerView>(R.id.rvItems)
        val adapter = FinishedOrdersAdapter(listOf(), finishedViewModel)
        rvItems.layoutManager = LinearLayoutManager(activity as MainActivity)
        rvItems.adapter = adapter

        finishedViewModel.getAllFinishedItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()

        })

        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, startFragment)
                commit()
            }
        }
    }
}