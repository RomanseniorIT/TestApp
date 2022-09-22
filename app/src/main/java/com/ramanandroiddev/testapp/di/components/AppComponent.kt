package com.ramanandroiddev.testapp.di.components

import com.ramanandroiddev.testapp.ui.MainActivity
import com.ramanandroiddev.testapp.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [AppModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}