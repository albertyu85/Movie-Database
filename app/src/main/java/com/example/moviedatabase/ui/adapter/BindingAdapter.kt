package com.example.moviedatabase.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.model.NowPlayingMovie

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
fun setItems(view: RecyclerView, items: List<NowPlayingMovie>?) {
//    view.adapter = MovieAdapter().apply {
//        if (!items.isNullOrEmpty()) {
//            setItems(ArrayList(items))
//        }
//        notifyDataSetChanged()
//    }
}