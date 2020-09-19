package com.example.moviedatabase.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.moviedatabase.model.NowPlayingMovie
import com.example.moviedatabase.repository.MovieRepository
import com.example.moviedatabase.repository.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailViewModel(repo : MovieRepository, id : Int, type: String) : ViewModel() {
    // TODO: Implement the ViewModel

    val movie : LiveData<Resource<NowPlayingMovie>> = repo.getNowPlayingId(id)
}