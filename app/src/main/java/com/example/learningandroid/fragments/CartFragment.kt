package com.example.learningandroid.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.learningandroid.ui.orderedlist.MainActivity
import com.example.learningandroid.R


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
        svItems.adapter = CustomAdapter(activity as MainActivity, items)
        tvItem.text = "${items.count()} items in the cart"

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