package com.example.moviedatabase.di

import androidx.room.Room
import com.example.moviedatabase.database.MovieDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val persistenceModule = module {

    single {
        Room.databaseBuilder(androidApplication(),
            MovieDatabase::class.java,
            "Movie.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<MovieDatabase>().movieDao()}
}