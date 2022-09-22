package com.ramanandroiddev.testapp.data

import com.ramanandroiddev.testapp.data.models.CatImageResponse
import retrofit2.http.GET

interface MainApi {

    @GET("images/search")
    suspend fun getCatImage(): CatImageResponse
}