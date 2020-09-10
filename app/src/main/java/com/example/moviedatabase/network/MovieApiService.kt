package com.example.moviedatabase.network

import com.example.moviedatabase.model.NowPlayingMovieResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "125084375dc1278f41dc6bc38687614f"

interface MovieApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page : Int = 1) : Response<NowPlayingMovieResult>

    @GET("movie/popular")
    fun getPopular(@Query("page") page : Int = 1) : NowPlayingMovieResult

    @GET("movie/top_rated")
    fun getTopRated(@Query("page") page : Int = 1) : NowPlayingMovieResult

    @GET("movie/upcoming")
    fun getUpcoming(@Query("page") page : Int = 1) : NowPlayingMovieResult

}