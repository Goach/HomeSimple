package com.goach.homesimple.vm

import androidx.databinding.ObservableField
import com.goach.homesimple.base.BaseViewModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 15:43
 * Des:文本
 **/
data class HomeContentModel(var content:ObservableField<String> = ObservableField()):BaseViewModel() {
}