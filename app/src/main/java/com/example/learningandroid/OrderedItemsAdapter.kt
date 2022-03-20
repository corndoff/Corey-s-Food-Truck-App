package com.example.learningandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroid.data.db.entity.OrderedItems
import com.example.learningandroid.ui.orderedlist.MainActivity
import com.example.learningandroid.ui.orderedlist.OrderedViewModel
import kotlinx.android.synthetic.main.fragment_cart.view.*
import kotlinx.android.synthetic.main.fragment_order_item.view.*
import kotlinx.android.synthetic.main.fragment_order_item.view.tvItem
import kotlinx.android.synthetic.main.fragment_placed_item.view.*

class OrderedItemsAdapter(
    var items: List<String>
): RecyclerView.Adapter<OrderedItemsAdapter.OrderedViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderedItemsAdapter.OrderedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_order_item, parent, false)
        return OrderedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OrderedItemsAdapter.OrderedViewHolder, position: Int) {
        val curOrderedItem = items[position]
        holder.itemView.tvItem.text = curOrderedItem

        //Setup interface to call deleteItemFromList from MainActivity then call Interface here
    }

    inner class OrderedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}