package com.example.moviedatabase.network

import android.util.Log
import com.example.moviedatabase.model.NowPlayingMovieResult
import com.example.moviedatabase.repository.Resource

class MovieRemoteDataSource(private val api: MovieApiService) : BaseDataSource() {

    suspend fun getNowPlayingMovies(page: Int = 1) : Resource<NowPlayingMovieResult> {
        Log.d("Network", "Calling API")
        return getResult { api.getNowPlaying(page) }
    }


}