package com.android.ljm.gate.databinding

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

object MyBindingAdapter {

    @BindingAdapter("myText", requireAll = false)
    @JvmStatic
    fun myText(view: TextView, str: String) {
        val toLowerCase = str.toLowerCase()
        view.text = toLowerCase
    }

    @BindingAdapter(value = ["url", "placeHolder"], requireAll = false)
    @JvmStatic
    fun setImageUrl(imageView: ImageView, url: String?, placeHolder: Drawable?) {
        if (url == null) {
            imageView.setImageDrawable(placeHolder)
        } else {
//            xxx
        }
    }

}