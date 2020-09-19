package com.example.moviedatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moviedatabase.model.NowPlayingMovie
//
@Dao
interface MovieDao {
    @Query("SELECT * FROM now_playing_movie_table")
    fun getAllNowPlaying() : LiveData<List<NowPlayingMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNowPlaying(movie : NowPlayingMovie)

    @Query("SELECT * FROM now_playing_movie_table WHERE id = :id LIMIT 1")
    fun getNowPlayingMovieById(id: Int) : LiveData<NowPlayingMovie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllNowPlaying(movies : List<NowPlayingMovie>)

    @Delete
    fun delete(movie: NowPlayingMovie)

}