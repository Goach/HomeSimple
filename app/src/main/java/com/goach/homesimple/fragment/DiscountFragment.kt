package com.goach.homesimple.fragment

import androidx.recyclerview.widget.RecyclerView
import com.goach.homesimple.R
import com.goach.homesimple.adapter.DiscountListAdapter
import com.goach.homesimple.base.BaseFragment
import com.goach.homesimple.base.RVTypeHelper
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.FragDiscountBinding
import com.goach.homesimple.vm.DisCountItemModel
import com.goach.homesimple.vm.GoodsViewModel
import kotlinx.android.synthetic.main.frag_discount.view.*

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:41
 * Des:特惠活动
 **/
class DiscountFragment : BaseFragment<FragDiscountBinding, GoodsViewModel>() {
    companion object {
        fun newInstance(): DiscountFragment = DiscountFragment()
    }

    override fun getLayoutId(): Int = R.layout.frag_discount

    override fun viewModelClass(): Class<GoodsViewModel> = GoodsViewModel::class.java
    override fun initData() {
        super.initData()
        val mDataList = mutableListOf<Any>()
        val imageUrls = arrayListOf(
            "http://www.ido99.cn/upload/image/2020/03/1583207184-5468.jpg",
            "http://img.aiimg.com/uploads/allimg/160507/1-16050G54Q3.jpg",
            "https://europcarchina.cn/upload/cover/7aqN7DM4UXC4y7n2eCqRFDItwSLVF5mtakjEc6cr.jpeg",
            "https://europcarchina.cn/upload/cover/aaYtud2OLWWgh4D85JpOfDj775LnIm9pmezx6Hhn.jpeg",
            "https://img.yxbao.com/article/image/202007/02/7a5f586178.jpg",
            "https://img.yxbao.com/article/image/202007/02/ead5880958.jpg"
        )
        for (i in 0..19) {
            val disCountItemModel = DisCountItemModel()
            disCountItemModel.disCountUrl.set(imageUrls[i % imageUrls.size])
            mDataList.add(disCountItemModel)
        }
        mRootView.rv_discount.adapter =
            RealRVAdapter(mDataList, RVTypeHelper().addAdapterType(DiscountListAdapter()).get())
    }

    fun getRV(): RecyclerView {
        return mRootView.rv_discount
    }
}