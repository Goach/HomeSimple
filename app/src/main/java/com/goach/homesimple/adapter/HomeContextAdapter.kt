package com.goach.homesimple.adapter

import androidx.databinding.ViewDataBinding
import com.goach.homesimple.R
import com.goach.homesimple.base.BaseTypeAdapter
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ListItemHomeContentBinding
import com.goach.homesimple.vm.HomeContentModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 15:40
 * Des:首页内容区域
 **/
class HomeContextAdapter : BaseTypeAdapter<ListItemHomeContentBinding,HomeContentModel>(){
    override fun isForViewType(item: Any?): Boolean  = item is HomeContentModel

    override fun getLayoutId(): Int = R.layout.list_item_home_content

    override fun updateView(
        holder: RealRVAdapter.BaseRVViewHolder,
        item: HomeContentModel,
        position: Int
    ) {
        mViewTypeDataBinding?.vm = item
        mViewTypeDataBinding?.executePendingBindings()
    }
}