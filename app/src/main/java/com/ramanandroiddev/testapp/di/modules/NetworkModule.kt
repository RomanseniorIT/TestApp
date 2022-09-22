package com.ramanandroiddev.testapp.di.modules

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.ramanandroiddev.testapp.BuildConfig
import com.ramanandroiddev.testapp.data.MainApi
import com.ramanandroiddev.testapp.data.HeadersInterceptor
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
class NetworkModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    fun provideProductionNewsService(): MainApi {
        val json = Json {
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        val okHttpClient = OkHttpClient().newBuilder().addInterceptor(HeadersInterceptor()).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(json.asConverterFactory(CONTENT_TYPE))
            .client(okHttpClient)
            .build()
        return retrofit.create(MainApi::class.java)
    }

    companion object {
        private val CONTENT_TYPE = "application/json; charset=utf-8".toMediaType()
    }
}