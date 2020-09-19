package com.example.moviedatabase

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.moviedatabase.database.MovieDao
import com.example.moviedatabase.database.MovieDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class LocalDatabase {

    private lateinit var db : MovieDatabase
    private lateinit var movieDao : MovieDao

    @Before
    fun createDb() {
        val context =InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, MovieDatabase::class.java).allowMainThreadQueries().build()
        movieDao = db.movieDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeMovie() {
        val movie = MockTestUtil.mockMovie()
        movie.type = "Now Playing"
        movieDao.insertNowPlaying(movie)
        val retrieve = movieDao.getNowPlayingMovieById(385103)
        assert(retrieve.title.equals("Scoob!"))
    }
}