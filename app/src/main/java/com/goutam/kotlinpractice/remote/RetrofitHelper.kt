package com.goutam.kotlinpractice.remote

import com.goutam.kotlinpractice.apphelper.ApplicationConstant
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class  RetrofitHelper{
    companion object {
        public fun getRetrofitInstance() : IRetrofitRequest {
            var retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(ApplicationConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(IRetrofitRequest::class.java)
        }
    }
}