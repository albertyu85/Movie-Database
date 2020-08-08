package com.example.moviedatabase.network

class MovieRemoteDataSource(private val api: MovieApiService) : BaseDataSource() {

    suspend fun getNowPlayingMovies(page: Int = 1) = getResult { api.getNowPlaying(page) }


}