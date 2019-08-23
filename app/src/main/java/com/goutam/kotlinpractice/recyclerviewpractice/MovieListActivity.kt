package com.goutam.kotlinpractice.recyclerviewpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.goutam.kotlinpractice.R
import com.goutam.kotlinpractice.recyclerviewpractice.model.Movies
import com.goutam.kotlinpractice.remote.RetrofitHelper
import com.goutam.kotlinpractice.utils.SimpleDividerItemDecoration
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity() {
    private lateinit var moviesAdapter : MoviesAdapter
    private var myCompositeDisposable : CompositeDisposable ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        myCompositeDisposable = CompositeDisposable()

        //Normal retrofit call
        /*var moviesCall = RetrofitHelper.getRetrofitInstance().getMovies()
        moviesCall.enqueue(object : Callback<Movies>{
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Toast.makeText(this@MovieListActivity,t.localizedMessage,Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                Log.e("MovieListActivity",response.body().toString())
                moviesAdapter = MoviesAdapter(this@MovieListActivity, response.body()!!)
                rcv_movies.layoutManager = LinearLayoutManager(this@MovieListActivity,LinearLayoutManager.VERTICAL,false)
                rcv_movies.adapter = moviesAdapter
                rcv_movies.addItemDecoration(SimpleDividerItemDecoration(this@MovieListActivity))
            }
        })*/

        //Retrofit call through RxJava
        var moviesCall = RetrofitHelper.getRetrofitInstance().getMovies()
        myCompositeDisposable?.add(moviesCall
            .subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse,this::handleError))
    }

    override fun onDestroy() {
        super.onDestroy()
        myCompositeDisposable?.clear()
    }

    fun handleResponse(movies : Movies){
        moviesAdapter = MoviesAdapter(this,movies)
        rcv_movies.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rcv_movies.adapter = moviesAdapter
        rcv_movies.addItemDecoration(SimpleDividerItemDecoration(this@MovieListActivity))
    }

    fun handleError(error : Throwable){
        Toast.makeText(this,error.localizedMessage,Toast.LENGTH_SHORT).show()
    }
}
