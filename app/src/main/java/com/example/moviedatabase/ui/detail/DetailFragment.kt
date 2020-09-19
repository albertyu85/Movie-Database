package com.example.moviedatabase.ui.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.moviedatabase.R
import com.example.moviedatabase.database.MovieDatabase
import com.example.moviedatabase.databinding.DetailFragmentBinding
import com.example.moviedatabase.repository.MovieRepository
import com.example.moviedatabase.repository.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    val args : DetailFragmentArgs by navArgs()
    private lateinit var viewModel : DetailViewModel
    private lateinit var viewModelFactory : DetailViewModelFactory
    private lateinit var binding : DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val type = args.type
        val id = args.id

        Log.d("Detail", "Type = $type and id = $id")

        viewModelFactory = DetailViewModelFactory(get<MovieRepository>(), id, type)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)

        when(type) {
            "Now Playing" -> {
                Log.d("Detail", "entered Now playing")
                    viewModel.nowPlayingMovie.observe(viewLifecycleOwner, Observer {
                        when(it.status) {
                            Resource.Status.SUCCESS -> {
                                if (it.data != null) binding.movie = it.data
                            }
                        }
                })
            }

        }


        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}