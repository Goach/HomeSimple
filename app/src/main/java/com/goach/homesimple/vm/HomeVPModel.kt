package com.goach.homesimple.vm

import androidx.databinding.ObservableField
import com.goach.homesimple.base.BaseViewModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:37
 * Des:
 **/
data class HomeVPModel(val tabTitle:ObservableField<String> = ObservableField()) : BaseViewModel()