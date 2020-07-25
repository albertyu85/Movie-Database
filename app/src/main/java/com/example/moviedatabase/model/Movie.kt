package com.example.moviedatabase.model

import com.google.gson.annotations.SerializedName

data class Movie(
                 @SerializedName("poster_path")
                 val posterPath : String?, val overview: String,
                 @SerializedName("release_date")
                 val releaseDate: String,
                 @SerializedName("genre_ids")
                 val genreID : IntArray,
                 val id: Int,
                 @SerializedName("original_title")
                 val originalTitle: String,
                 @SerializedName("original_language")
                 val originalLanguage: String,
                 val title : String,
                 @SerializedName("backdrop_path")
                 val backdropPath: String?,
                 val popularity: Double,
                 @SerializedName("vote_count")
                 val voteCount: Int,
                 @SerializedName("vote_average")
                 val voteAverage: Double) {
}