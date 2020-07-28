package com.goach.homesimple.fragment

import androidx.recyclerview.widget.RecyclerView
import com.goach.homesimple.R
import com.goach.homesimple.adapter.GoodsListAdapter
import com.goach.homesimple.base.BaseFragment
import com.goach.homesimple.base.RVTypeHelper
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.FragGoodsBinding
import com.goach.homesimple.vm.GoodsItemModel
import com.goach.homesimple.vm.GoodsViewModel
import kotlinx.android.synthetic.main.frag_goods.view.*

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:41
 * Des:
 **/
class GoodsFragment : BaseFragment<FragGoodsBinding, GoodsViewModel>() {
    companion object {
        fun newInstance(): GoodsFragment = GoodsFragment()
    }

    override fun getLayoutId(): Int = R.layout.frag_goods

    override fun viewModelClass(): Class<GoodsViewModel> = GoodsViewModel::class.java
    override fun initData() {
        super.initData()
        val mDataList = mutableListOf<Any>()
        val imageUrls = arrayListOf(
            "https://i.keaitupian.net/up/9d/1b/15/95904baf6fe19d3a1a66c2f200151b9d.jpg",
            "https://i.keaitupian.net/up/5c/02/f1/fc83ac054f83d2f72015b001ddf1025c.jpg",
            "https://i.keaitupian.net/up/b3/36/05/6da0a1e76a504a9ef3291aa4540536b3.jpg",
            "https://i.keaitupian.net/up/d1/b2/16/ef67618664f378ebb2a7065abe16b2d1.jpg",
            "https://i.keaitupian.net/up/2f/a3/1c/a34fdc2f34b73e06b280ecee2b1ca32f.jpg",
            "https://i.keaitupian.net/up/85/3d/02/5af82f3faaabd8afcc292d7ba7023d85.jpg",
            "https://i.keaitupian.net/up/16/a3/dc/393e9caf8e5c24489f3d6bc858dca316.jpg"
        )
        for (i in 0..19) {
            val goodsItemModel = GoodsItemModel()
            goodsItemModel.goodsTitle.set("货品${i + 1}")
            goodsItemModel.goodsUrl.set(imageUrls[i % imageUrls.size])
            mDataList.add(goodsItemModel)
        }
        mRootView.rv_goods.adapter =
            RealRVAdapter(mDataList, RVTypeHelper().addAdapterType(GoodsListAdapter()).get())
    }

    fun getRV(): RecyclerView {
        return mRootView.rv_goods
    }
}