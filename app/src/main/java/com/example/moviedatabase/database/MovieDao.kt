package com.example.moviedatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviedatabase.model.Movie
//
@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_table WHERE type = 'Now Playing'")
    fun getAllNowPlaying() : LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlaying(movie : Movie)

    @Query("SELECT * FROM movie_table WHERE id = :id LIMIT 1")
    fun getMovieById(id: Int) : LiveData<Movie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNowPlaying(movies : List<Movie>)

    @Delete
    fun delete(movie: Movie)

}