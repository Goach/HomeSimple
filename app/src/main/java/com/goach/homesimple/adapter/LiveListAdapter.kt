package com.goach.homesimple.adapter

import com.goach.homesimple.R
import com.goach.homesimple.base.BaseTypeAdapter
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ListItemDiscountBinding
import com.goach.homesimple.databinding.ListItemLiveBinding
import com.goach.homesimple.vm.LiveItemModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 10:12
 * Des:特惠活动Adapter
 **/
class LiveListAdapter : BaseTypeAdapter<ListItemLiveBinding, LiveItemModel>() {
    override fun isForViewType(item: Any?): Boolean = item is LiveItemModel

    override fun getLayoutId(): Int = R.layout.list_item_live

    override fun updateView(
        holder: RealRVAdapter.BaseRVViewHolder,
        item: LiveItemModel,
        position: Int
    ) {
        mViewTypeDataBinding?.vm = item
        mViewTypeDataBinding?.executePendingBindings()
    }
}