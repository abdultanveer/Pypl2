package com.example.pypl2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerActivity : AppCompatActivity() {
    var languages = arrayOf("english","hindi","tamil","telgu","kannada","urdu")

    lateinit var  languagesrecyView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        languagesrecyView = findViewById(R.id.recyclerView)

//        var myAdapter = ArrayAdapter(this,
//            android.R.layout.simple_list_item_1,
//            android.R.id.text1,
//            languages)

        var myAdapter = LangsAdapter(languages)
        languagesrecyView.layoutManager = LinearLayoutManager(this)
        languagesrecyView.adapter = myAdapter

    }
}