package com.example.pypl2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RecyclerActivity : AppCompatActivity() {
    var languages = arrayOf("english","hindi","tamil","telgu","kannada","urdu")

    lateinit var  languagesListView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        languagesListView = findViewById(R.id.listView)

        var myAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            languages)
        languagesListView.adapter = myAdapter

    }
}