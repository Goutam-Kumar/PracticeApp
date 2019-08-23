package com.goutam.kotlinpractice.recyclerviewpractice.model

import com.google.gson.annotations.SerializedName

data class Data(@SerializedName("year")
                val year: String = "",
                @SerializedName("genre")
                val genre: String = "",
                @SerializedName("id")
                val id: Int = 0,
                @SerializedName("title")
                val title: String = "",
                @SerializedName("poster")
                val poster: String = "")