package com.album.albumapplication.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

class ImageUtils {
    companion object {
        fun loadImageFromUrl(
            context: Context,
            urlImage: String,
            imageView: ImageView,
            placeHolder: Int
        ) {
            var userAgent = "album"
            val glideUrl = GlideUrl(
                urlImage, LazyHeaders.Builder()
                    .addHeader("User-Agent", userAgent)
                    .build()
            )

            Glide.with(context)
                .load(glideUrl)
                .placeholder(placeHolder)
                .into(imageView)

        }
    }
}