package com.goach.homesimple.adapter

import com.goach.homesimple.R
import com.goach.homesimple.base.BaseTypeAdapter
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ListItemBuyerBinding
import com.goach.homesimple.vm.BuyerItemModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 10:12
 * Des:特惠活动Adapter
 **/
class BuyerAdapter : BaseTypeAdapter<ListItemBuyerBinding, BuyerItemModel>() {
    override fun isForViewType(item: Any?): Boolean = item is BuyerItemModel

    override fun getLayoutId(): Int = R.layout.list_item_buyer

    override fun updateView(
        holder: RealRVAdapter.BaseRVViewHolder,
        item: BuyerItemModel,
        position: Int
    ) {
        mViewTypeDataBinding?.vm = item
        mViewTypeDataBinding?.executePendingBindings()
    }
}