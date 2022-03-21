package com.example.learningandroid.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.learningandroid.data.db.entity.FinishedItems

@Dao
interface FinishedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: FinishedItems)
    // we write suspend so these functions can be used asynchronously with coroutines

    @Delete
    suspend fun delete(item: FinishedItems)

    @Query("SELECT * FROM finished_items")
    fun getAllFinishedItems(): LiveData<List<FinishedItems>>
}