package com.goach.homesimple.base

import android.view.View
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:17
 * Des:RecyclerView的Adapter
 **/
class RealRVAdapter(private var mDataList: MutableList<Any>, private var mAdapterTypes: SparseArrayCompat<BaseTypeAdapter<*, *>>) :
    RecyclerView.Adapter<RealRVAdapter.BaseRVViewHolder>() {
    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        if (mAdapterTypes.isEmpty) {
            return
        }
        for (index in 0 until mAdapterTypes.size()) {
            mAdapterTypes.valueAt(index)?.attachRecyclerView(recyclerView, mDataList)
        }
    }
    override fun getItemViewType(position: Int): Int {
        if (position < 0 || position >= mDataList.size) {
            return 0
        }
        for (index in 0 until mAdapterTypes.size()) {
            val itemType = mAdapterTypes.valueAt(index)
            if (itemType.isForViewType(mDataList[position])) {
                return mAdapterTypes.keyAt(index)
            }
        }
        throw IllegalArgumentException(
            "No BaseMultiRecyclerAdapter added that matches," +
                    "You should addMultiAdapter it first"
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRVViewHolder {
        return mAdapterTypes.get(viewType)!!.onCreateViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int = mDataList.size

    override fun onBindViewHolder(holder: BaseRVViewHolder, position: Int) {
        mAdapterTypes.get(holder.itemViewType)!!.onBindViewHolder(holder, mDataList[position], position)
    }

    class BaseRVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}