package com.goach.homesimple.vm

import androidx.databinding.ObservableField
import com.goach.homesimple.base.BaseViewModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 16:25
 * Des:
 **/
data class HomeGridModel(var gridTitle1:ObservableField<String> = ObservableField(),
                    var gridTitle2:ObservableField<String> = ObservableField()
):BaseViewModel()