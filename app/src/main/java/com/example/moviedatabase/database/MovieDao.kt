package com.example.moviedatabase.database

import androidx.room.*
import com.example.moviedatabase.model.Movie
//
@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table WHERE type = 'Now Playing'")
    fun getAllNowPlaying() : List<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlaying(movie : Movie) {
        movie.type = "Now Playing"
    }

    @Delete
    fun delete(movie: Movie)

}