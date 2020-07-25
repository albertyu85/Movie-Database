package com.example.moviedatabase.ui.nowplaying

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviedatabase.R

class NowPlayingFragment : Fragment() {

    companion object {
        fun newInstance() =
            NowPlayingFragment()
    }

    private lateinit var viewModel: NowPlayingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.now_playing_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NowPlayingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}