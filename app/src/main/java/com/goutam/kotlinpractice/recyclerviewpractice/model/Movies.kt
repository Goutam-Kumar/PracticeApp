package com.goutam.kotlinpractice.recyclerviewpractice.model

import com.google.gson.annotations.SerializedName

data class Movies(@SerializedName("data")
                  val data: List<Data>?)