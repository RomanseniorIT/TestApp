package com.ramanandroiddev.testapp.data

import com.ramanandroiddev.testapp.data.models.CatImageResponse
import com.ramanandroiddev.testapp.domain.MainRepository
import com.ramanandroiddev.testapp.domain.models.CatImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainApi: MainApi,
    private val catImageMapper: CatImageMapper
) : MainRepository {

    override suspend fun getCatImage(): CatImage {
        val catListResponse = withContext(Dispatchers.IO) {
            mainApi.getCatImage()
        }
        val catResponse = catListResponse.firstOrNull() ?: CatImageResponse()

        return catImageMapper(catResponse)
    }
}