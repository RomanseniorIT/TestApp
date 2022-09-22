package com.ramanandroiddev.testapp.data

import com.ramanandroiddev.testapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeadersInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val requestBuilder = chain.request().newBuilder()

        if (BuildConfig.API_KEY.isNotEmpty()) requestBuilder.header("x-api-key", BuildConfig.API_KEY)
        requestBuilder.header("Content-type", "application/json")

        val request = requestBuilder.build()

        return chain.proceed(request)
    }
}