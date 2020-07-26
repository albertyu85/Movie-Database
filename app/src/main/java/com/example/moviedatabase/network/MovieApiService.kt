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

    companion object {
        operator fun invoke() : MovieApiService {
            val requestInterceptor = Interceptor {
                val url = it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .build()
                val request = it.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor it.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApiService::class.java)
        }
    }
}