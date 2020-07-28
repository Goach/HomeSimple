package com.goach.homesimple.fragment

import androidx.recyclerview.widget.RecyclerView
import com.goach.homesimple.R
import com.goach.homesimple.adapter.BuyerAdapter
import com.goach.homesimple.base.BaseFragment
import com.goach.homesimple.base.RVTypeHelper
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.FragBuyerBinding
import com.goach.homesimple.vm.BuyerItemModel
import com.goach.homesimple.vm.GoodsViewModel
import kotlinx.android.synthetic.main.frag_buyer.view.*

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:41
 * Des:买家秀
 **/
class BuyerFragment : BaseFragment<FragBuyerBinding, GoodsViewModel>() {
    companion object {
        fun newInstance(): BuyerFragment = BuyerFragment()
    }

    override fun getLayoutId(): Int = R.layout.frag_buyer

    override fun viewModelClass(): Class<GoodsViewModel> = GoodsViewModel::class.java
    override fun initData() {
        super.initData()
        val mDataList = mutableListOf<Any>()
        val imageUrls = arrayListOf(
            "https://img.zcool.cn/community/0119da55b83e5d32f875251f5d2a4f.jpg@1280w_1l_2o_100sh.jpg",
            "http://5b0988e595225.cdn.sohucs.com/images/20180802/7f818817cecb4d389c69a15939a8f8ac.jpg",
            "http://news.66wz.com/pic/003/000/536/00300053684_d54a0981.jpg",
            "http://5b0988e595225.cdn.sohucs.com/images/20190723/8efc471e689141eca0a472b23438eff5.jpeg",
            "http://www.gexing.me/uploads/allimg/160811/6-160Q10Z431604.jpg",
            "http://img.mp.itc.cn/upload/20160516/31176ebaa96f4b15b5df9ecf15362cc9_th.jpg"
        )
        for (i in 0..19) {
            val buyerItemModel = BuyerItemModel()
            buyerItemModel.buyerUrl.set(imageUrls[i % imageUrls.size])
            mDataList.add(buyerItemModel)
        }
        mRootView.rv_buyer.adapter =
            RealRVAdapter(mDataList, RVTypeHelper().addAdapterType(BuyerAdapter()).get())
    }

    fun getRV(): RecyclerView {
        return mRootView.rv_buyer
    }
}