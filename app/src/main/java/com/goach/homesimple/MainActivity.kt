package com.goach.homesimple

import com.goach.homesimple.adapter.HomeAdAdapter
import com.goach.homesimple.adapter.HomeContextAdapter
import com.goach.homesimple.adapter.HomeGridAdapter
import com.goach.homesimple.adapter.HomeTabAdapter
import com.goach.homesimple.base.BaseActivity
import com.goach.homesimple.base.RVTypeHelper
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.ActivityMainBinding
import com.goach.homesimple.vm.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:23
 * Des:首页
 **/
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun getLayoutId(): Int = R.layout.activity_main
    override fun viewModelClass(): Class<MainViewModel> = MainViewModel::class.java
    override fun initData() {
        super.initData()
        val list = mutableListOf<Any>()
        val homeAdModel = HomeAdModel()
        homeAdModel.adUrl.set("https://img95.699pic.com/photo/40100/6015.jpg_wh300.jpg")
        list.add(homeAdModel)
        val homeContentModel = HomeContentModel()
        homeContentModel.content.set("清仓大甩卖，全场八折")
        list.add(homeContentModel)
        val homeGridModel = HomeGridModel()
        homeGridModel.gridTitle1.set("签到")
        homeGridModel.gridTitle2.set("尊贵VIP")
        list.add(homeGridModel)

        val homeContentModel2 = HomeContentModel()
        homeContentModel2.content.set("这个夏天，让你狂欢一次")
        list.add(homeContentModel2)
        val homeGridModel2 = HomeGridModel()
        homeGridModel2.gridTitle1.set("电视专区")
        homeGridModel2.gridTitle2.set("手机专区")
        list.add(homeGridModel2)

        val homeTabModel = HomeTabModel()
        list.add(homeTabModel)
        val mHomeTabAdapter = HomeTabAdapter(mFM, ssl_view)
        rv_list.adapter = RealRVAdapter(
            list, RVTypeHelper().addAdapterType(HomeAdAdapter())
                .addAdapterType(HomeContextAdapter())
                .addAdapterType(HomeGridAdapter())
                .addAdapterType(mHomeTabAdapter).get()
        )
    }
}
