package com.ramanandroiddev.testapp

import android.app.Application
import android.content.Context
import com.ramanandroiddev.testapp.di.components.AppComponent
import com.ramanandroiddev.testapp.di.components.DaggerAppComponent

class MainApp: Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> applicationContext.appComponent
    }