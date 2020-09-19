package com.example.moviedatabase.repository

import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.moviedatabase.network.MovieRemoteDataSource
import com.example.moviedatabase.database.MovieDao
import com.example.moviedatabase.model.NowPlayingMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MovieRepository(private val remoteDataSource: MovieRemoteDataSource, private val dao: MovieDao) {


//    suspend fun fetchNowPlaying(page: Int = 1) {
//        val response = client.getNowPlaying(page)
//        for (movie in response.results) {
//            movie.type = "Now Playing"
//            dao.insertNowPlaying(movie)
//        }
//
//    }

    fun getNowPlaying() =
        performGetOperation(
            databaseQuery = {dao.getAllNowPlaying()},
            networkCall = { remoteDataSource.getNowPlayingMovies() },
            saveCallResult = {dao.insertAllNowPlaying(it.results)}
        )

    fun getNowPlayingId(id: Int) = liveData<Resource<NowPlayingMovie>>(Dispatchers.IO) {
        emit(Resource.loading())
        val source = dao.getNowPlayingMovieById(id).map { Resource.success(it) }
        emitSource(source)
    }


}