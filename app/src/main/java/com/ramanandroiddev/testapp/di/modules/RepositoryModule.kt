package com.ramanandroiddev.testapp.di.modules

import com.ramanandroiddev.testapp.domain.MainRepository
import com.ramanandroiddev.testapp.domain.models.CatImage
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    //Todo("implement repository")
    @Provides
    fun provideRepository(): MainRepository = object : MainRepository {
        override suspend fun getCatImage(): CatImage {
            return CatImage("")
        }
    }
}