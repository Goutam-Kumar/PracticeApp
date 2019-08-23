package com.goutam.kotlinpractice.apphelper

import android.content.Context
import android.widget.ImageView
import com.goutam.kotlinpractice.R
import com.squareup.picasso.Picasso

class AppHelper {
    companion object{
        fun setPictureWithCache(imageView: ImageView, path: String) {
            Picasso.get().load(path).noFade().error(R.drawable.ic_launcher_background).placeholder(R.drawable.ic_launcher_background).into(imageView)
        }
    }
}