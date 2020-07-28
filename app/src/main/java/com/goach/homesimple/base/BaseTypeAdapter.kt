package com.goach.homesimple.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:25
 * Des:多样式RV的BaseAdapter
 **/
abstract class BaseTypeAdapter<B : ViewDataBinding,D> {
    lateinit var mRecyclerView: RecyclerView
    lateinit var mDataList: MutableList<*>
    protected open lateinit var mCtx: Context
    protected open var mViewTypeDataBinding: B? = null
    fun attachRecyclerView(recyclerView: RecyclerView, list: MutableList<*>) {
        this.mRecyclerView = recyclerView
        this.mDataList = list
        mCtx = recyclerView.context
    }

    abstract fun isForViewType(item: Any?): Boolean
    fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RealRVAdapter.BaseRVViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewHolder: RealRVAdapter.BaseRVViewHolder
        val resource = getLayoutId()
        lateinit var itemView:View
        viewHolder = if (resource > 0) {
            itemView = layoutInflater.inflate(resource, parent, false)
            RealRVAdapter.BaseRVViewHolder(itemView)
        } else {
            itemView = createItemView()!!
            RealRVAdapter.BaseRVViewHolder(itemView)
        }
        initView(viewHolder, viewType)
        return viewHolder
    }
    fun onBindViewHolder(holder: RealRVAdapter.BaseRVViewHolder, item: Any, position: Int) {
        mViewTypeDataBinding = DataBindingUtil.bind(holder.itemView)!!
        updateView(holder, item as D, position)
    }

    abstract fun getLayoutId(): Int
    protected open fun createItemView(): View? {
        return null
    }

    protected open fun initView(viewHolder: RealRVAdapter.BaseRVViewHolder, viewType: Int) {}
    abstract fun updateView(holder: RealRVAdapter.BaseRVViewHolder, item: D, position: Int)
}