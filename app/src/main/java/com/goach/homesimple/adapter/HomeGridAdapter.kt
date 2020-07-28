package com.goach.homesimple.adapter

import com.goach.homesimple.R
import com.goach.homesimple.base.BaseTypeAdapter
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ListItemHomeGridBinding
import com.goach.homesimple.vm.HomeGridModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 16:24
 * Des:
 **/
class HomeGridAdapter :BaseTypeAdapter<ListItemHomeGridBinding,HomeGridModel>() {
    override fun isForViewType(item: Any?): Boolean = item is HomeGridModel

    override fun getLayoutId(): Int = R.layout.list_item_home_grid

    override fun updateView(
        holder: RealRVAdapter.BaseRVViewHolder,
        item: HomeGridModel,
        position: Int
    ) {
        mViewTypeDataBinding?.vm = item
        mViewTypeDataBinding?.executePendingBindings()
    }
}