package com.ramanandroiddev.testapp.domain

import com.ramanandroiddev.testapp.domain.models.CatImage

interface Repository {

    suspend fun getCatImage(): CatImage
}