package com.example.moviedatabase.network

import com.example.moviedatabase.model.Movie
import com.example.moviedatabase.model.MovieResult
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "125084375dc1278f41dc6bc38687614f"

interface MovieApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(@Query("page") page : Int = 1) : MovieResult

    @GET("movie/popular")
    fun getPopular(@Query("page") page : Int = 1) : MovieResult

    @GET("movie/top_rated")
    fun getTopRated(@Query("page") page : Int = 1) : MovieResult

    @GET("movie/upcoming")
    fun getUpcoming(@Query("page") page : Int = 1) : MovieResult

}