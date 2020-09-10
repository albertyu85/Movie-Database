package com.example.moviedatabase.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviedatabase.model.NowPlayingMovie

@Database(entities = [NowPlayingMovie::class], version = 3, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
}