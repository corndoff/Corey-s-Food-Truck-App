package com.example.learningandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.learningandroid.fragments.StartFragment
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private var order:MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startFragment = StartFragment()
        val fragment = findViewById<FrameLayout>(R.id.navFragment)

        supportFragmentManager.beginTransaction().apply {
            replace(fragment.id, startFragment)
            commit()
        }
    }

    fun getItemList(): List<String>{
        var items: MutableList<String> = mutableListOf()
        items = this.order
        return items
    }

    fun addItemToList(item: String){
        this.order.add(item)
    }

}