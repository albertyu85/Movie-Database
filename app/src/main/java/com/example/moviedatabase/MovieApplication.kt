package com.example.moviedatabase

import android.app.Application
import com.example.moviedatabase.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MovieApplication)
            modules(networkModule)
            modules(repositoryModule)
            modules(viewModelModule)
            modules(persistenceModule)
            modules(dataSourceModule)
        }
    }
}