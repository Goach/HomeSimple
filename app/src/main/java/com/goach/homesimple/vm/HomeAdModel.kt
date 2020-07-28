package com.goach.homesimple.vm

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import com.goach.homesimple.base.BaseViewModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 11:48
 * Des:
 **/
data class HomeAdModel(var adUrl:ObservableField<String> = ObservableField(),
        var placeholder:ObservableField<Drawable> = ObservableField()
) : BaseViewModel()