package com.example.learningandroid.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.learningandroid.data.db.entity.OrderedItems

@Database(
    entities = [OrderedItems::class],
    version = 1
// everytime you update the database somehow you have to update the version or Room will throw an error
)
abstract class OrderedFoodDatabase: RoomDatabase() {

    abstract fun getOrderedDao(): OrderedDao
    // this makes sure we can access our database operations from inside our database class

    //companion is what static means in Java
    companion object {
        @Volatile
        private var instance: OrderedFoodDatabase? = null
        // this creates a singleton so the program doesn't create multiple instances of the database
        // volatile means that writes to the instance will be made available instantly to other threads
        // this makes sure only one thread is writing to the instance at a time


        private val LOCK = Any()

        // operator fun with invoke gets called every time the database is initiated. Ie FoodDatabase()
        // the also keyword means we set our instance to whatever the result of the function we called is
        operator fun invoke(context: Context) = instance ?: kotlin.synchronized(LOCK){
            instance ?: createDatabase(context).also {
                instance = it
            }
        }


        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, OrderedFoodDatabase::class.java, "FoodOrdersDB.db").build()


    }
}