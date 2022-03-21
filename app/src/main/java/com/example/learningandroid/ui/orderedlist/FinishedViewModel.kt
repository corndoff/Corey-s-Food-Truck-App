package com.example.learningandroid.ui.orderedlist

import androidx.lifecycle.ViewModel
import com.example.learningandroid.data.db.entity.FinishedItems
import com.example.learningandroid.data.db.entity.OrderedItems
import com.example.learningandroid.data.repositories.FinishedRepository
import com.example.learningandroid.data.repositories.OrderRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FinishedViewModel(
    private val repository: FinishedRepository
): ViewModel() {

    fun upsert(item: FinishedItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: FinishedItems) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllFinishedItems() = repository.getAllFinishedItems()
}