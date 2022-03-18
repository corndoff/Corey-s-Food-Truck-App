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
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment(R.layout.fragment_cart) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val database = OrderedFoodDatabase(activity as MainActivity  )
        val repository = OrderRepository(database)
        val factory = OrderedViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(OrderedViewModel::class.java)

        //viewModel.upsert()

        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val btnPlaceOrder = view.findViewById<Button>(R.id.btnPlaceOrder)
        val startFragment = StartFragment()
        val orderFragment = OrderFragment()
        val rvItems = view.findViewById<RecyclerView>(R.id.rvItems)
        val edTableNumber = view.findViewById<EditText>(R.id.edTableNumber)
        val items = (activity as MainActivity).getItemList()
        val adapter = OrderedItemsAdapter(items, viewModel)
        rvItems.layoutManager = LinearLayoutManager(activity as MainActivity)
        rvItems.adapter = adapter
        adapter.notifyDataSetChanged()

        (activity as MainActivity).getItemList()
        //.observe(viewLifecycleOwner, Observer {
        //    adapter.items = it
        //    adapter.notifyDataSetChanged()
        //})


        btnPlaceOrder.setOnClickListener {
            if(edTableNumber.text.isEmpty()){
                Toast.makeText(activity as MainActivity, "Please provide your table number", Toast.LENGTH_SHORT)
            }else {
                for (item in items) {
                    val orderedItem = OrderedItems(edTableNumber.text.toString().toInt(), item)
                    viewModel.upsert(orderedItem)
                }
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment, startFragment)
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

    private class CustomAdapter(context: Context, items:List<String>): BaseAdapter(){

        private val myContext: Context
        private val myItems:List<String>

        init{
            myContext = context
            myItems = items
        }

        override fun getCount(): Int {
            return myItems.count()
        }

        override fun getItem(p0: Int): Any {
            return "Test"
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val textView = TextView((myContext as MainActivity))
            textView.text = myItems[p0]
            return textView
        }

    }
}