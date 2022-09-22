package com.ramanandroiddev.testapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramanandroiddev.testapp.domain.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val catLiveData = MutableLiveData<String>()

    init {
        getCatImage()
    }

    fun catLiveData(): LiveData<String> = catLiveData

    fun getCatImage() {
        viewModelScope.launch {
            val catImage = repository.getCatImage()
            catLiveData.value = catImage.imageUrl
        }
    }
}