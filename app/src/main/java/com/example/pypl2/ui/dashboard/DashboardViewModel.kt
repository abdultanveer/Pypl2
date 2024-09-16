package com.example.pypl2.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pypl2.network.MarsApi
import com.example.pypl2.network.MarsPhoto
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {
    var allWords = MutableLiveData<List<MarsPhoto>>()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun getMarsPhotos() {
        viewModelScope.launch {
             allWords.value  = MarsApi.retrofitService.getPhotos()

        }
    }
}