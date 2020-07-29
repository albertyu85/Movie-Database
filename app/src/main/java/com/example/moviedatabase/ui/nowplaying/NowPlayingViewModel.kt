package com.example.moviedatabase.ui.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedatabase.repository.MovieRepository
import com.example.moviedatabase.model.MovieResult
import com.example.moviedatabase.network.MovieApiService
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class NowPlayingViewModel : ViewModel() {

    private val job = Job()
    private val coroutineContext : CoroutineContext
        get() = job + Dispatchers.IO
    private val scope = CoroutineScope(coroutineContext)

    private var movieList = MutableLiveData<MovieResult>()
    val response : LiveData<MovieResult>
        get() = movieList

    fun getNowPlayingList() {
        val repository =
            MovieRepository(MovieApiService())
        scope.launch() {
            val response = repository.loadNowPlaying()
            movieList.postValue(response)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}