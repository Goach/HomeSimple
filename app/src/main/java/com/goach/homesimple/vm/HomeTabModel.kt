package com.goach.homesimple.vm

import androidx.databinding.ObservableField
import com.goach.homesimple.base.BaseViewModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 17:48
 * Des:
 **/
data class HomeTabModel(var tabData:ObservableField<String> = ObservableField()) : BaseViewModel()