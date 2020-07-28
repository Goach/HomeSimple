package com.goach.homesimple.bind

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.goach.homesimple.utils.GlideApp

/**
 * author: Goach.zhong
 * Date: 2020-07-24 15:08
 * Des:BindingAdapter 相关方法
 **/
@BindingAdapter(value = ["loadUrl", "placeHolder"], requireAll = false)
fun loadUrl(
    view: ImageView,
    loadUrl: String?,
    placeHolder: Drawable?
) {
    GlideApp.with(view.context).load(loadUrl).placeholder(placeHolder).error(placeHolder).dontAnimate()
        .into(view)
}