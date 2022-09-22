package com.ramanandroiddev.testapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatImageResponse(
    @SerialName("url") val imageUrl: String? = null
)