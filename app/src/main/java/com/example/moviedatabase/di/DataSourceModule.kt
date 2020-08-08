package com.example.moviedatabase.di

import com.example.moviedatabase.network.MovieRemoteDataSource
import org.koin.dsl.module

val dataSourceModule =  module {
    single { MovieRemoteDataSource(get()) }
}