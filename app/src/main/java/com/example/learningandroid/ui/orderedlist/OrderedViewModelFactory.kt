package com.example.learningandroid.ui.orderedlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learningandroid.data.repositories.OrderRepository

class OrderedViewModelFactory(
    private val repository: OrderRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OrderedViewModel(repository) as T
    }
}