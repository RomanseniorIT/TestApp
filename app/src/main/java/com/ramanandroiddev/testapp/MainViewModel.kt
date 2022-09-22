package com.ramanandroiddev.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    init {
        getCatImage()
    }

    private val catLiveData = MutableLiveData<String>()

    fun catLiveData(): LiveData<String> = catLiveData

    fun getCatImage() {

    }
}