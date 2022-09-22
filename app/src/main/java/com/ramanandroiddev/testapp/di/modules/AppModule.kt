package com.ramanandroiddev.testapp.di.modules

import dagger.Module

@Module(includes = [RepositoryModule::class, ViewModelModule::class, NetworkModule::class])
class AppModule