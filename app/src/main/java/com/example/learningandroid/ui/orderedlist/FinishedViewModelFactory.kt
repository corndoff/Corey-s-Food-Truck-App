package com.example.learningandroid.ui.orderedlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.learningandroid.data.repositories.FinishedRepository
import com.example.learningandroid.data.repositories.OrderRepository

class FinishedViewModelFactory(
    private val repository: FinishedRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FinishedViewModel(repository) as T
    }
}