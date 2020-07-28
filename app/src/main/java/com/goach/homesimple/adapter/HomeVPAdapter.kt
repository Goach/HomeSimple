package com.goach.homesimple.adapter

import androidx.collection.SparseArrayCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.goach.homesimple.base.BaseVPAdapter
import com.goach.homesimple.fragment.BuyerFragment
import com.goach.homesimple.fragment.DiscountFragment
import com.goach.homesimple.fragment.GoodsFragment
import com.goach.homesimple.fragment.LiveFragment
import com.goach.homesimple.vm.HomeVPModel

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:36
 * Des:
 **/
class HomeVPAdapter(mDataList: List<HomeVPModel>, fm: FragmentManager) :
    BaseVPAdapter<HomeVPModel>(mDataList, fm) {
    private var mListRV: SparseArrayCompat<Fragment> = SparseArrayCompat()
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> {
                val discountFrag = DiscountFragment.newInstance()
                mListRV.put(position, discountFrag)
                discountFrag
            }
            2 -> {
                val liveFrag = LiveFragment.newInstance()
                mListRV.put(position, liveFrag)
                liveFrag
            }
            3 -> {
                val buyerFrag = BuyerFragment.newInstance()
                mListRV.put(position, buyerFrag)
                buyerFrag
            }
            else -> {
                val goodsFrag = GoodsFragment.newInstance()
                mListRV.put(position, goodsFrag)
                goodsFrag
            }
        }
    }

    override fun getTitle(item: HomeVPModel): CharSequence? {
        return item.tabTitle.get()
    }

    fun getCurrentRV(position: Int): RecyclerView? {
        if (mListRV[position] is GoodsFragment) {
            return (mListRV[position] as GoodsFragment).getRV()
        }
        if (mListRV[position] is DiscountFragment) {
            return (mListRV[position] as DiscountFragment).getRV()
        }
        if (mListRV[position] is LiveFragment) {
            return (mListRV[position] as LiveFragment).getRV()
        }
        if (mListRV[position] is BuyerFragment) {
            return (mListRV[position] as BuyerFragment).getRV()
        }
        return null
    }
}