package com.example.learningandroid.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "finished_items")
data class FinishedItems(
    @ColumnInfo(name = "table_number")
    var table: Int,
    @ColumnInfo(name = "table_order")
    var item: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}