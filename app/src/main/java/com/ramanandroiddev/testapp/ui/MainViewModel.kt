package com.ramanandroiddev.testapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramanandroiddev.testapp.R
import com.ramanandroiddev.testapp.domain.MainRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val catLiveData = MutableLiveData<String>()
    private val errorLiveData = MutableLiveData<Int>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        when (throwable) {
            is SocketTimeoutException, is UnknownHostException, is HttpException -> {
                errorLiveData.value = R.string.network_error
            }
            else -> errorLiveData.value = R.string.unknown_error
        }
    }

    init {
        getCatImage()
    }

    fun catLiveData(): LiveData<String> = catLiveData
    fun errorLiveData(): LiveData<Int> = errorLiveData

    fun getCatImage() {
        viewModelScope.launch(exceptionHandler) {
            val catImage = repository.getCatImage()
            catLiveData.value = catImage.imageUrl
        }
    }
}