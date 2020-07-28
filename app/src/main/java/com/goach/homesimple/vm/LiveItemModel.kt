package com.goach.homesimple.vm

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import com.goach.homesimple.base.BaseViewModel

/**
 * author: Goach.zhong
 * Date: 2020-07-28 16:09
 * Des:
 **/
data class LiveItemModel(var liveUrl:ObservableField<String> = ObservableField(),
                         var placeholder: ObservableField<Drawable> = ObservableField()):BaseViewModel()