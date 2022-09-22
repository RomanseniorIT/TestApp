package com.ramanandroiddev.testapp.data

import com.ramanandroiddev.testapp.data.models.CatImageResponse
import com.ramanandroiddev.testapp.domain.models.CatImage
import javax.inject.Inject

class CatImageMapper @Inject constructor() {

    operator fun invoke(response: CatImageResponse): CatImage = with(response) {
        CatImage(
            imageUrl = imageUrl ?: ""
        )
    }
}