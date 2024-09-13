package com.example.pypl2

import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var dataDbWebserviceDb = 0

    fun incrementCounter(){
        dataDbWebserviceDb++
    }

}