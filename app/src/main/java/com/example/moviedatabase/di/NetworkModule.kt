package com.example.moviedatabase.di

import com.example.moviedatabase.network.MovieApiService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        val requestInterceptor = Interceptor {
            val url = it.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", "125084375dc1278f41dc6bc38687614f")
                .build()
            val request = it.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor it.proceed(request)
        }

        OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(MovieApiService::class.java)
    }
}