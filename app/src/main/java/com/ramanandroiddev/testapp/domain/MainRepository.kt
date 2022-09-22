package com.ramanandroiddev.testapp.domain

import com.ramanandroiddev.testapp.domain.models.CatImage

interface MainRepository {

    suspend fun getCatImage(): CatImage
}