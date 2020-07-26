package com.example.moviedatabase.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedatabase.R
import com.example.moviedatabase.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

private const val baseUrl = "https://image.tmdb.org/t/p/w500"
class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var items: MutableList<Movie> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        val item = items[position]
        Glide.with(holder.image.context)
            .load(baseUrl + item.posterPath)
            .into(holder.image)
        holder.bind(item.title)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title_textView
        val image = view.movie_imageView
        fun bind(name: String) {
            title.text = name
        }
    }
}