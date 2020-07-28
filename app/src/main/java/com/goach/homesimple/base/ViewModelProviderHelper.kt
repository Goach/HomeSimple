package com.goach.homesimple.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider


/**
 * author: Goach.zhong
 * Date: 2020-07-24 15:03
 *  Des:获取各种ViewModelProvider
 **/
class ViewModelProviderHelper {
    private var mActivityVMProvider: ViewModelProvider? = null
    private var mFragmentVMProvider: ViewModelProvider? = null

    /**
     * 获取 Activity ViewModelProvider
     */
    fun getActivityVMProvider(owner: AppCompatActivity): ViewModelProvider? {
        if (mActivityVMProvider == null) mActivityVMProvider = ViewModelProvider(owner)
        return mActivityVMProvider
    }

    /**
     * 获取 Fragment ViewModelProvider
     */
    fun getFragmentVMProvider(owner: Fragment): ViewModelProvider? {
        if (mFragmentVMProvider == null) mFragmentVMProvider = ViewModelProvider(owner)
        return mFragmentVMProvider
    }
}