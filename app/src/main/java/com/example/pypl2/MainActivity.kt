package com.example.pypl2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pypl2.datastorage.Item
import com.example.pypl2.datastorage.ItemDao
import com.example.pypl2.datastorage.ItemRoomDatabase
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var dao: ItemDao
    lateinit var tv: TextView
    lateinit var viewModel: MainViewModel

    //var dataDbWebserviceDb = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        tv = findViewById(R.id.textView)

        tv.setText("" + viewModel.dataDbWebserviceDb)
        viewModel._seconds.observe(this, secsObserver); //me giving my phno to the postman
        //plz inform this observer when secs change


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
            var item = dao.getItem(11).first()
            var tv: TextView = findViewById(R.id.textView)
            tv.setText(item.itemName)
        }
    }


    fun incrementCount(view: View) {
        viewModel.startTimer()
        //  tv.setText(""+viewModel._seconds)
    }

    var secsObserver: Observer<Int> = object : Observer<Int> {
        override fun onChanged(value: Int) {
            //receiving the update/notification
            tv.setText(value.toString())
        }
        /*  fun incrementCounter(){
        dataDbWebserviceDb++
    }*/
    }

    fun sendDataFs(view: View) {
        val db = Firebase.firestore
        val user = hashMapOf(
            "first" to "abdul",
            "last" to "tannveer",
            "born" to 1815
        )

// Add a new document with a generated ID
        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("MainActivity", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("MainActivity", "Error adding document", e)
            }

    }

    fun getDataFs(view: View) {
        val db = Firebase.firestore

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("MainActivity", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("MainActivity", "Error getting documents.", exception)
            }
    }
}