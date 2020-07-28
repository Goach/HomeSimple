package com.goach.homesimple.adapter

import android.util.Log
import androidx.core.content.ContextCompat
import com.goach.homesimple.R
import com.goach.homesimple.base.BaseTypeAdapter
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ListItemHomeAdBinding
import com.goach.homesimple.vm.HomeAdModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 10:42
 * Des:首页Banner类型
 **/
class HomeAdAdapter : BaseTypeAdapter<ListItemHomeAdBinding, HomeAdModel>() {
    override fun isForViewType(item: Any?): Boolean {
        return item is HomeAdModel
    }

    override fun getLayoutId(): Int = R.layout.list_item_home_ad

    override fun updateView(
        holder: RealRVAdapter.BaseRVViewHolder,
        item: HomeAdModel,
        position: Int
    ) {
        mViewTypeDataBinding?.vm = item
        mViewTypeDataBinding?.vm?.placeholder?.set(ContextCompat.getDrawable(mCtx,R.drawable.placeholder_128_128))
        mViewTypeDataBinding?.executePendingBindings()
    }
}