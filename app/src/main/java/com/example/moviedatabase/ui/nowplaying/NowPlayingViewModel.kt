package com.example.moviedatabase.ui.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedatabase.model.Movie
import com.example.moviedatabase.model.MovieResult
import com.example.moviedatabase.network.MovieApiService
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class NowPlayingViewModel : ViewModel() {

    private val job = Job()
    private val coroutineContext : CoroutineContext
        get() = job + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    private val movieList = MutableLiveData<MovieResult>()
    val response : LiveData<MovieResult>
        get() = movieList

    fun getNowPlayingList() {
        scope.launch() {
            val response = MovieApiService().getNowPlaying()
            movieList.postValue(response)
        }
    }
}