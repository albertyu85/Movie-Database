package com.example.moviedatabase.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedatabase.R
import com.example.moviedatabase.databinding.ItemMovieBinding
import com.example.moviedatabase.model.NowPlayingMovie
import com.example.moviedatabase.ui.DetailFragmentArgs
import com.example.moviedatabase.ui.nowplaying.NowPlayingFragmentDirections

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val items = ArrayList<NowPlayingMovie>()

    fun setItems(items: ArrayList<NowPlayingMovie>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.movie = item
        //   val action = SpecifyAmountFragmentDirections.confirmationAction(amount)
        //   v.findNavController().navigate(action)
        val movie = holder.binding.movie
        var id = 0
        if (movie != null)
            id = movie.id
        val type = when(holder.binding.movie) {
            is NowPlayingMovie -> "Now Playing"
            else -> "Movie"
        }
        holder.binding.movieImageView.setOnClickListener {
            val action = NowPlayingFragmentDirections.actionNowPlayingFragmentToDetailFragment(type, id)
            it.findNavController().navigate(action)
        }
    }


    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}