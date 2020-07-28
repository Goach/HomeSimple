package com.goach.homesimple.adapter

import com.goach.homesimple.R
import com.goach.homesimple.base.BaseTypeAdapter
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ListItemGoodsBinding
import com.goach.homesimple.vm.GoodsItemModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 10:12
 * Des:
 **/
class GoodsListAdapter : BaseTypeAdapter<ListItemGoodsBinding, GoodsItemModel>() {
    override fun isForViewType(item: Any?): Boolean = item is GoodsItemModel

    override fun getLayoutId(): Int = R.layout.list_item_goods

    override fun updateView(
        holder: RealRVAdapter.BaseRVViewHolder,
        item: GoodsItemModel,
        position: Int
    ) {
        mViewTypeDataBinding?.vm = item
        mViewTypeDataBinding?.executePendingBindings()
    }
}