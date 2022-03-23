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
import com.example.learningandroid.ui.orderedlist.MainActivity
import com.example.learningandroid.R
import com.example.learningandroid.data.db.OrderedFoodDatabase
import com.example.learningandroid.data.db.entity.OrderedItems
import com.example.learningandroid.data.repositories.OrderRepository
import com.example.learningandroid.ui.orderedlist.OrderedViewModel
import com.example.learningandroid.ui.orderedlist.OrderedViewModelFactory
import com.example.learningandroid.ui.orderedlist.PaymentDialog
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment(R.layout.fragment_cart) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = OrderedFoodDatabase(activity as MainActivity  )
        val repository = OrderRepository(database)
        val factory = OrderedViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(OrderedViewModel::class.java)

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val btnPlaceOrder = view.findViewById<Button>(R.id.btnPlaceOrder)
        val startFragment = StartFragment()
        val orderFragment = OrderFragment()
        val rvItems = view.findViewById<RecyclerView>(R.id.rvItems)
        val ivDelete = view.findViewById<ImageView>(R.id.ivDelete)
        val edTableNumber = view.findViewById<EditText>(R.id.edTableNumber)
        val items = (activity as MainActivity).getItemList()
        val adapter = OrderedItemsAdapter(items, (activity as MainActivity))
        rvItems.layoutManager = LinearLayoutManager(activity as MainActivity)
        rvItems.adapter = adapter


        btnPlaceOrder.setOnClickListener {
            if(edTableNumber.text.isEmpty()){
                Toast.makeText(activity as MainActivity, "Please provide your table number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val paymentDialog = PaymentDialog()
            paymentDialog.show(parentFragmentManager, "Payment Window")
            //for (item in items) {
            //    val orderedItem = OrderedItems(edTableNumber.text.toString().toInt(), item)
            //    viewModel.upsert(orderedItem)
            //}
            //(activity as MainActivity).clearList()
            //parentFragmentManager.beginTransaction().apply {
            //    replace(R.id.fragment, startFragment)
            //    commit()
            //}

        }

        btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, orderFragment)
                commit()
            }
        }
    }
}