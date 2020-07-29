package com.example.moviedatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moviedatabase.model.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao

    companion object {
        @Volatile private var INSTANCE : MovieDatabase? = null

        fun getInstance(context: Context) : MovieDatabase =
            INSTANCE
                ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(
                        context
                    )
                        .also { INSTANCE = it}
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                MovieDatabase::class.java,
                "Movie.db")
                .fallbackToDestructiveMigration()
                .build()
    }
}