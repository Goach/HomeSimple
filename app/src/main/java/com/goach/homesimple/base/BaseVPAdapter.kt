package com.goach.homesimple.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:06
 * Des:ViewPager Adapter
 **/
abstract class BaseVPAdapter<D>(private val mDataList:List<D>, fm: FragmentManager) : FragmentStatePagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        return createFragment(position)
    }

    override fun getCount(): Int  = mDataList.size
    override fun getPageTitle(position: Int): CharSequence? {
        return getTitle(mDataList[position])
    }
    abstract fun createFragment(position: Int):Fragment
    abstract fun getTitle(item:D):CharSequence?
}