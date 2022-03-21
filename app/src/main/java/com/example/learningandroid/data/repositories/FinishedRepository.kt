package com.example.learningandroid.data.repositories

import com.example.learningandroid.data.db.FinishedFoodDatabase
import com.example.learningandroid.data.db.OrderedFoodDatabase
import com.example.learningandroid.data.db.entity.FinishedItems
import com.example.learningandroid.data.db.entity.OrderedItems

class FinishedRepository(
    private val db: FinishedFoodDatabase
) {

    // this repository functions will be called from the ViewModel
    // first we go through the database then through the DAO to get the functions
    //Ie db(for the database).getOrderedDao()(for the DAO).upsert(item)
    suspend fun upsert(item: FinishedItems) = db.getFinishedDao().upsert(item)

    suspend fun delete(item: FinishedItems) = db.getFinishedDao().delete(item)

    fun getAllFinishedItems() = db.getFinishedDao().getAllFinishedItems()
}