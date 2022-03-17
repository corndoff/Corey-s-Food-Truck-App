package com.example.learningandroid.data.repositories

import com.example.learningandroid.data.db.OrderedFoodDatabase
import com.example.learningandroid.data.db.entity.OrderedItems

class OrderRepository(
    private val db: OrderedFoodDatabase
) {

    // this repository functions will be called from the ViewModel
    // first we go through the database then through the DAO to get the functions
    //Ie db(for the database).getOrderedDao()(for the DAO).upsert(item)
    suspend fun upsert(item: OrderedItems) = db.getOrderedDao().upsert(item)

    suspend fun delete(item: OrderedItems) = db. getOrderedDao().delete(item)

    fun getAllOrderedItems() = db.getOrderedDao().getAllOrderedItems()
}