package com.ramanandroiddev.testapp.di.modules

import com.ramanandroiddev.testapp.data.MainRepositoryImpl
import com.ramanandroiddev.testapp.domain.MainRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {

    @Binds
    fun provideRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository
}