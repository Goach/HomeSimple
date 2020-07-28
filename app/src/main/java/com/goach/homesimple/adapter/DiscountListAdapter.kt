package com.goach.homesimple.adapter

import com.goach.homesimple.R
import com.goach.homesimple.base.BaseTypeAdapter
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ListItemDiscountBinding
import com.goach.homesimple.vm.DisCountItemModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 10:12
 * Des:特惠活动Adapter
 **/
class DiscountListAdapter : BaseTypeAdapter<ListItemDiscountBinding, DisCountItemModel>() {
    override fun isForViewType(item: Any?): Boolean = item is DisCountItemModel

    override fun getLayoutId(): Int = R.layout.list_item_discount

    override fun updateView(
        holder: RealRVAdapter.BaseRVViewHolder,
        item: DisCountItemModel,
        position: Int
    ) {
        mViewTypeDataBinding?.vm = item
        mViewTypeDataBinding?.executePendingBindings()
    }
}