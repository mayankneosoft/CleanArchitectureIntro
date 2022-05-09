package com.exam.foodsearchcaintro.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.exam.foodsearchcaintro.R

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, s: String?) {
    val options = RequestOptions.placeholderOf(R.drawable.loading).error(R.drawable.error)
    Glide.with(view).setDefaultRequestOptions(options).load(s ?: "").into(view)
}