package com.example.telstrapoc.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.telstrapoc.R
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

object GlideImageDownloader {
    @JvmStatic
    @BindingAdapter("android:src")
    fun downloadImage( img: ImageView,url: String?) {
        // Progress bar to show till image gets download
        val circularProgressDrawable = CircularProgressDrawable(CountryFeatureApplication.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 20f
        circularProgressDrawable.start()

        if (url != null && url.length > 0 &&  !url.equals("") ) {
            Glide.with(CountryFeatureApplication.context).load(url).error(R.mipmap.ic_launcher).placeholder(circularProgressDrawable).into(img)
        } else {
            Glide.with(CountryFeatureApplication.context).load(R.mipmap.ic_launcher).placeholder(circularProgressDrawable).into(img)
        }
    }
}