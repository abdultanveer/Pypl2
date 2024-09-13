package com.example.pypl2

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.pypl2.datastorage.Item
import com.example.pypl2.datastorage.ItemDao
import com.example.pypl2.datastorage.ItemRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var dao: ItemDao
lateinit var  tv:TextView
    lateinit var viewModel:MainViewModel

    //var dataDbWebserviceDb = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        tv = findViewById(R.id.textView)

        tv.setText(""+ viewModel.dataDbWebserviceDb)


        var database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()
        //database.close()

    }

    fun commitData(view: View) {
        var gItem = Item(11, "fruits", 12.99, 12)

        GlobalScope.launch {
            dao.insert(gItem)

        }
    }

    fun getData(view: View) {
        GlobalScope.launch(Dispatchers.Main) {
           var item =  dao.getItem(11).first()
            var tv:TextView = findViewById(R.id.textView)
            tv.setText(item.itemName)
        }
    }



    fun incrementCount(view: View) {
       // incrementCounter()
        viewModel.incrementCounter()
        tv.setText(""+viewModel.dataDbWebserviceDb)
    }

  /*  fun incrementCounter(){
        dataDbWebserviceDb++
    }*/
}