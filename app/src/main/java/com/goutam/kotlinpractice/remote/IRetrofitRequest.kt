package com.goutam.kotlinpractice.remote

import com.goutam.kotlinpractice.recyclerviewpractice.model.Movies
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface IRetrofitRequest {
    //Retrofit call by RxJava
    @GET("/filippella/Sample-API-Files/master/json/movies-api.json")
    fun getMovies() : Observable<Movies>

    //Normal Retrofit call
    //fun getMovies() : Call<Movies>
}