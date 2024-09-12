package com.example.pypl2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pypl2.datastorage.Item
import com.example.pypl2.datastorage.ItemDao
import com.example.pypl2.datastorage.ItemRoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var dao: ItemDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

    }

    fun commitData(view: View) {
        var gItem = Item(11, "fruits", 12.99, 12)

        GlobalScope.launch {
            dao.insert(gItem)

        }
    }
}