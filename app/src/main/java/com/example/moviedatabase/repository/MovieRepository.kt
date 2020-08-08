package com.example.moviedatabase.repository

import com.example.moviedatabase.network.MovieRemoteDataSource
import com.example.moviedatabase.database.MovieDao

class MovieRepository(private val remoteDataSource: MovieRemoteDataSource, private val dao: MovieDao) {


//    suspend fun fetchNowPlaying(page: Int = 1) {
//        val response = client.getNowPlaying(page)
//        for (movie in response.results) {
//            movie.type = "Now Playing"
//            dao.insertNowPlaying(movie)
//        }
//
//    }

    fun getNowPlaying()  = performGetOperation(
        databaseQuery = {dao.getAllNowPlaying()},
        networkCall = { remoteDataSource.getNowPlayingMovies() },
        saveCallResult = {dao.insertAllNowPlaying(it.results)}

    )
}