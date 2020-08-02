package com.example.moviedatabase.ui.nowplaying

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.moviedatabase.R
import com.example.moviedatabase.databinding.NowPlayingFragmentBinding
import com.example.moviedatabase.ui.adapter.MovieAdapter
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.getViewModel

class NowPlayingFragment : Fragment() {

    companion object {
        fun newInstance() =
            NowPlayingFragment()
    }

    private val viewModel : NowPlayingViewModel by viewModels { NowPlayingViewModelFactory(get())}
    private lateinit var binding : NowPlayingFragmentBinding

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {

    binding = DataBindingUtil.inflate(inflater, R.layout.now_playing_fragment, container, false)
    binding.apply {
        lifecycleOwner = viewLifecycleOwner
        viewModel = viewModel
        adapter = MovieAdapter()
    }
    return binding.root
}

override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel.getNowPlayingList()

    viewModel.response.observe(viewLifecycleOwner, Observer {
        binding.adapter?.items = it.results
    })
}

}