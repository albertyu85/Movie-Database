package com.example.moviedatabase.ui.nowplaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviedatabase.repository.MovieRepository

class NowPlayingViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NowPlayingViewModel(repository) as T
    }
}