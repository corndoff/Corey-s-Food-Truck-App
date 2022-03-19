package com.example.learningandroid.ui.orderedlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.learningandroid.R
import com.example.learningandroid.data.db.OrderedFoodDatabase
import com.example.learningandroid.data.repositories.OrderRepository
import com.example.learningandroid.fragments.StartFragment
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity()/*, KodeinAware*/ {

    /*override val kodein by kodein()
    private val factory: OrderedViewModelFactory by instance()*/



    private var order:MutableList<String> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = OrderedFoodDatabase(this)
        val repository = OrderRepository(database)
        val factory = OrderedViewModelFactory(repository)

        val viewModel = ViewModelProvider(this, factory).get(OrderedViewModel::class.java)

        val startFragment = StartFragment()
        val fragment = findViewById<FrameLayout>(R.id.navFragment)


        supportFragmentManager.beginTransaction().apply {
            replace(fragment.id, startFragment)
            commit()
        }
    }
    fun getItemList(): List<String> {
        var items: MutableList<String> = mutableListOf()
        items = order
        return items
    }

    fun addItemToList(item: String){
        order.add(item)

    }

}