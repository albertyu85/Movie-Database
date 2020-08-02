package com.example.moviedatabase.di

import com.example.moviedatabase.ui.nowplaying.NowPlayingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NowPlayingViewModel(get()) }
}