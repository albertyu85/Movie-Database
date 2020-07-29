package com.example.moviedatabase.repository

import android.provider.Settings
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviedatabase.model.Movie
import com.example.moviedatabase.model.MovieResult
import com.example.moviedatabase.network.MovieApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieRepository(val client: MovieApiService) {

    private val nowPlayingResponse : MutableLiveData<MovieResult> = MutableLiveData<MovieResult>()

    suspend fun loadNowPlaying(page: Int = 1) : MovieResult {
        return client.getNowPlaying(page)
    }
}