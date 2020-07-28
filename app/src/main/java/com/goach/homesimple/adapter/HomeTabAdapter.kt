package com.goach.homesimple.adapter

import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.goach.homesimple.R
import com.goach.homesimple.base.BaseTypeAdapter
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ListItemHomeTabBinding
import com.goach.homesimple.view.SmoothScrollLayout
import com.goach.homesimple.vm.HomeTabModel
import com.goach.homesimple.vm.HomeVPModel
import kotlinx.android.synthetic.main.list_item_home_tab.view.*

/**
 * author: Goach.zhong
 * Date: 2020-07-24 17:46
 * Des:
 **/
class HomeTabAdapter(
    private val mFM: FragmentManager,
    private val scrollLayout: SmoothScrollLayout
) :
    BaseTypeAdapter<ListItemHomeTabBinding, HomeTabModel>() {
    private var mHomeTabAdapter: HomeVPAdapter? = null
    private var mViewPager: ViewPager? = null
    private var mItemView: View? = null
    override fun isForViewType(item: Any?): Boolean = item is HomeTabModel

    override fun getLayoutId(): Int = R.layout.list_item_home_tab
    override fun initView(viewHolder: RealRVAdapter.BaseRVViewHolder, viewType: Int) {
        super.initView(viewHolder, viewType)
        val tabList = mutableListOf<HomeVPModel>()
        val goodsTab = HomeVPModel()
        goodsTab.tabTitle.set("购物")
        tabList.add(goodsTab)
        val discountTab = HomeVPModel()
        discountTab.tabTitle.set("特惠")
        tabList.add(discountTab)
        val liveTab = HomeVPModel()
        liveTab.tabTitle.set("直播")
        tabList.add(liveTab)
        val buyTab = HomeVPModel()
        buyTab.tabTitle.set("买家秀")
        tabList.add(buyTab)
        mHomeTabAdapter = HomeVPAdapter(tabList, mFM)
        mItemView = viewHolder.itemView
        mViewPager = viewHolder.itemView.vp_type
        mViewPager?.adapter = mHomeTabAdapter
        viewHolder.itemView.tb_type.setupWithViewPager(viewHolder.itemView.vp_type)
        scrollLayout.setBorderView(mItemView)
        mViewPager?.post {
            scrollLayout.setChildRV(getCurrentRV())
        }
        mViewPager?.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                scrollLayout.setChildRV(getCurrentRV())
            }

        })
    }

    override fun updateView(
        holder: RealRVAdapter.BaseRVViewHolder,
        item: HomeTabModel,
        position: Int
    ) {
    }

    fun getItemView(): View? {
        return mItemView
    }

    fun getViewPager(): ViewPager? {
        return mViewPager
    }

    fun getCurrentRV(): RecyclerView? {
        return mHomeTabAdapter?.getCurrentRV(mViewPager?.currentItem ?: 0)
    }
}