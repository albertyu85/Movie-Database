package com.example.moviedatabase.ui.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviedatabase.repository.Resource
import com.example.moviedatabase.model.NowPlayingMovie
import com.example.moviedatabase.repository.MovieRepository

class NowPlayingViewModel(private val repo : MovieRepository) : ViewModel() {

//    private val job = Job()
//    private val coroutineContext : CoroutineContext
//        get() = job + Dispatchers.IO
//    private val scope = CoroutineScope(coroutineContext)
//
//    private var movieList = MutableLiveData<List<Movie>>()
//    val response : LiveData<List<Movie>>
//        get() = movieList
//
//    fun getNowPlayingList() {
//        scope.launch() {
//            repo.fetchNowPlaying()
//            val response = repo.getNowPlaying()
//            movieList.postValue(response)
//        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        job.cancel()
//    }

    val movies : LiveData<Resource<List<NowPlayingMovie>>> = repo.getNowPlaying()
}