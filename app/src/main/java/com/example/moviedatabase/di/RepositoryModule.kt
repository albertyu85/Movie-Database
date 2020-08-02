package com.example.moviedatabase.di

import com.example.moviedatabase.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        MovieRepository(get(), get())
    }
}