package com.example.moviedatabase

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.model.Movie
import com.example.moviedatabase.ui.adapter.MovieAdapter

private const val baseURL = "https://image.tmdb.org/t/p/w500"

@BindingAdapter("image")
fun loadImage(movieImageView: ImageView, url: String) {
    Glide.with(movieImageView.context)
        .load(baseURL + url)
        .into(movieImageView)
}

@BindingAdapter("bind:adapter")
fun setAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
    view.adapter = baseAdapter
}

@BindingAdapter("bind:items")
fun setItems(view: RecyclerView, items: MutableList<Movie>?) {
    view.adapter = MovieAdapter().apply {
        this.items = items ?: mutableListOf()
        notifyDataSetChanged()
    }
}