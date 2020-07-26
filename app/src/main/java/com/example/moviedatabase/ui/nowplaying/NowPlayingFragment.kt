package com.example.moviedatabase.ui.nowplaying

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedatabase.R
import com.example.moviedatabase.model.Movie
import com.example.moviedatabase.network.MovieApiService
import com.example.moviedatabase.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.now_playing_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
        val id = intArrayOf(1, 2, 3, 4)
        val movie1 = Movie("asdfasdfasdf", "asdf", "ASDF", id, 1, "asdf", "adsfasd", "Testing Movie Title", "asdfasdf", 2.2, 4, 2.2 )

        val list = mutableListOf(Movie("asdfasdfasdf", "asdf", "ASDF", id, 1, "asdf", "adsfasd", "Testing Movie Title", "asdfasdf", 2.2, 4, 2.2 ),
            Movie("asdfasdfasdf", "asdf", "ASDF", id, 1, "asdf", "adsfasd", "Testing Movie Title", "asdfasdf", 2.2, 4, 2.2 ) ,
            Movie("asdfasdfasdf", "asdf", "ASDF", id, 1, "asdf", "adsfasd", "Testing Movie Title 2", "asdfasdf", 2.2, 4, 2.2 ),
            Movie("asdfasdfasdf", "asdf", "ASDF", id, 1, "asdf", "adsfasd", "Testing Movie Title 3", "asdfasdf", 2.2, 4, 2.2 ),
            Movie("asdfasdfasdf", "asdf", "ASDF", id, 1, "asdf", "adsfasd", "Testing Movie Title 4", "asdfasdf", 2.2, 4, 2.2 ),
            Movie("asdfasdfasdf", "asdf", "ASDF", id, 1, "asdf", "adsfasd", "Testing Movie Title 5", "asdfasdf", 2.2, 4, 2.2 ),
            Movie("asdfasdfasdf", "asdf", "ASDF", id, 1, "asdf", "adsfasd", "Testing Movie Title 6", "asdfasdf", 2.2, 4, 2.2 ))
        val adapter = MovieAdapter()
        adapter.items = list
//        GlobalScope.launch(Dispatchers.Main) {
//            val response = MovieApiService().getNowPlaying()
//            //nowPlaying_textView.text = response.results[1].title
//
//        }
//        nowPlaying_recyclerView.adapter = adapter
//        nowPlaying_recyclerView.layoutManager = GridLayoutManager(context, 3)


    }

}