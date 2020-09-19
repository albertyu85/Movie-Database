package com.example.moviedatabase.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedatabase.repository.MovieRepository
import com.example.moviedatabase.ui.nowplaying.NowPlayingViewModel

class DetailViewModelFactory(private val repository: MovieRepository, private val id: Int, private val type: String) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(repository, id, type) as T
    }
}