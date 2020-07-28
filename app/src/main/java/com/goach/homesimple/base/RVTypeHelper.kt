package com.goach.homesimple.base

import androidx.collection.SparseArrayCompat

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:44
 * Des:RV 类型集合管理
 **/
class RVTypeHelper {
    private val mAdapterTypes: SparseArrayCompat<BaseTypeAdapter<*, *>> = SparseArrayCompat()
    fun addAdapterType(baseTypeAdapter: BaseTypeAdapter<*, *>): RVTypeHelper {
        val adapterTypeKey = baseTypeAdapter.hashCode()
        if (!mAdapterTypes.containsKey(adapterTypeKey)) {
            mAdapterTypes.put(adapterTypeKey, baseTypeAdapter)
        }
        return this
    }

    fun removeAdapterType(baseTypeAdapter: BaseTypeAdapter<*, *>): RVTypeHelper {
        val adapterTypeKey = baseTypeAdapter.hashCode()
        if (mAdapterTypes.containsKey(adapterTypeKey)) {
            mAdapterTypes.remove(adapterTypeKey)
        }
        return this
    }
    fun get():SparseArrayCompat<BaseTypeAdapter<*, *>>{
        return mAdapterTypes
    }

}