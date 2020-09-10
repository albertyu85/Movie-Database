package com.example.moviedatabase.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedatabase.databinding.ItemMovieBinding
import com.example.moviedatabase.model.NowPlayingMovie

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
    }


    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}