package com.example.learningandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.learningandroid.data.db.entity.OrderedItems
import com.example.learningandroid.ui.orderedlist.OrderedViewModel
import kotlinx.android.synthetic.main.fragment_cart.view.*
import kotlinx.android.synthetic.main.fragment_order_item.view.*
import kotlinx.android.synthetic.main.fragment_order_item.view.tvItem
import kotlinx.android.synthetic.main.fragment_placed_item.view.*

class PlacedOrdersAdapter(
    var items: List<OrderedItems>
): RecyclerView.Adapter<PlacedOrdersAdapter.OrderedViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlacedOrdersAdapter.OrderedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_placed_item, parent, false)
        return OrderedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PlacedOrdersAdapter.OrderedViewHolder, position: Int) {
        val curOrderedItem = items[position]
        holder.itemView.tvItem.text = curOrderedItem.item
        holder.itemView.tvTable.text = curOrderedItem.table.toString()

        holder.itemView.ivCheck.setOnClickListener{
            holder.itemView.ivCheck.visibility = View.INVISIBLE
            holder.itemView.ivCheckGreen.visibility = View.VISIBLE
        }
    }

    inner class OrderedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}