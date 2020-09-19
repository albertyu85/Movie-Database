package com.example.moviedatabase.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviedatabase.model.NowPlayingMovie
import com.example.moviedatabase.repository.MovieRepository
import com.example.moviedatabase.repository.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailViewModel(val repo : MovieRepository,val  id : Int, val type: String) : ViewModel() {
    // TODO: Implement the ViewModel
    val nowPlayingMovie = repo.getNowPlayingId(id)
}