package com.goutam.kotlinpractice.recyclerviewpractice

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.goutam.kotlinpractice.R
import com.goutam.kotlinpractice.apphelper.AppHelper
import com.goutam.kotlinpractice.recyclerviewpractice.model.Data
import com.goutam.kotlinpractice.recyclerviewpractice.model.Movies

class MoviesAdapter(var context: Context, var listOfMovies: Movies) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){
    val TAG : String = "MoviesAdapter"
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_movies,null))
    }

    override fun getItemCount(): Int {
        Log.e(TAG,listOfMovies.data!!.size.toString())
       return listOfMovies.data!!.size
    }

    override fun onBindViewHolder(p0: MoviesViewHolder, p1: Int) {
        p0.bindMovies(listOfMovies.data!!.get(p1))
    }


    inner class MoviesViewHolder (itemView : View)  : RecyclerView.ViewHolder(itemView){
        var imgMovies : ImageView = itemView.findViewById(R.id.img_movies)
        var txtName : TextView = itemView.findViewById(R.id.txt_name)
        var txtGenre : TextView = itemView.findViewById(R.id.txt_genre)
        var txtYear : TextView = itemView.findViewById(R.id.txt_year)
        fun bindMovies (movie : Data){
            txtName.setText(movie.title)
            txtGenre.setText(movie.genre)
            txtYear.setText(movie.year)
            AppHelper.setPictureWithCache(imgMovies,movie.poster);
        }
    }
}