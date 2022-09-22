package com.ramanandroiddev.testapp.data.models

import kotlinx.serialization.SerialName

data class CatImageResponse(
    @SerialName("url") val imageUrl: String? = null
)