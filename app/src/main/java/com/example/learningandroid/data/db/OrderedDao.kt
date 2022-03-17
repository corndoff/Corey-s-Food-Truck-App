package com.example.learningandroid.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.learningandroid.data.db.entity.OrderedItems

@Dao
interface OrderedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: OrderedItems)
    // we write suspend so these functions can be used asynchronously with coroutines

    @Delete
    suspend fun delete(item: OrderedItems)

    @Query("SELECT * FROM ordered_items")
    fun getAllOrderedItems(): LiveData<List<OrderedItems>>
}