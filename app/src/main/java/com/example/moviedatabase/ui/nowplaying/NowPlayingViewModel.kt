package com.example.moviedatabase.ui.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedatabase.model.Movie
import com.example.moviedatabase.repository.MovieRepository
import com.example.moviedatabase.model.MovieResult
import com.example.moviedatabase.network.MovieApiService
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class NowPlayingViewModel(private val repo : MovieRepository) : ViewModel() {

    private val job = Job()
    private val coroutineContext : CoroutineContext
        get() = job + Dispatchers.IO
    private val scope = CoroutineScope(coroutineContext)

    private var movieList = MutableLiveData<List<Movie>>()
    val response : LiveData<List<Movie>>
        get() = movieList

    fun getNowPlayingList() {
        scope.launch() {
            repo.fetchNowPlaying()
            val response = repo.getNowPlaying()
            movieList.postValue(response)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}