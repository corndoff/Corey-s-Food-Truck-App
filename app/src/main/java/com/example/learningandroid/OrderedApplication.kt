package com.example.learningandroid

import android.app.Application
import com.example.learningandroid.data.db.OrderedFoodDatabase
import com.example.learningandroid.data.repositories.OrderRepository
import com.example.learningandroid.ui.orderedlist.OrderedViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class OrderedApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@OrderedApplication))
        bind() from singleton { OrderedFoodDatabase(instance()) }
        bind() from singleton { OrderRepository(instance()) }
        bind() from provider { OrderedViewModelFactory(instance()) }
    }
}