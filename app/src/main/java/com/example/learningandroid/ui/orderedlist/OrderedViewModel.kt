package com.example.learningandroid.ui.orderedlist

import androidx.lifecycle.ViewModel
import com.example.learningandroid.data.db.entity.OrderedItems
import com.example.learningandroid.data.repositories.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OrderedViewModel(
    private val repository: OrderRepository
): ViewModel() {

    fun upsert(item: OrderedItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: OrderedItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllOrderedItems() = repository.getAllOrderedItems()
}