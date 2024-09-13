package com.example.pypl2

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    lateinit var timer: CountDownTimer
    var _seconds = MutableLiveData<Int>()  //_ means its a mutable variable



    var dataDbWebserviceDb = 0 //observable

    fun incrementCounter(){
        dataDbWebserviceDb++
    }

    fun startTimer():Unit{
        timer = object :CountDownTimer(10_000,1_000){
            override fun onTick(millisUntilFinished: Long) {
                Log.i(TAG,"time remaining --"+millisUntilFinished)
                _seconds.value = millisUntilFinished.toInt()

            }

            override fun onFinish() {
                Log.i(TAG,"timer finished")
            }
        }.start()
    }

    companion object{
        var TAG = MainViewModel::class.java.simpleName
    }

}