package com.example.moviedatabase.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedatabase.R
import com.example.moviedatabase.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

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
        holder.bind(item.title)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.title_textView
        fun bind(name: String) {
            title.text = name
        }
    }
}