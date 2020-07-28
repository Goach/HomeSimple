package com.goach.homesimple.fragment

import androidx.recyclerview.widget.RecyclerView
import com.goach.homesimple.R
import com.goach.homesimple.adapter.LiveListAdapter
import com.goach.homesimple.base.BaseFragment
import com.goach.homesimple.base.RVTypeHelper
import com.goach.homesimple.base.RealRVAdapter
import com.goach.homesimple.databinding.FragLiveBinding
import com.goach.homesimple.vm.GoodsViewModel
import com.goach.homesimple.vm.LiveItemModel
import kotlinx.android.synthetic.main.frag_live.view.*

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:41
 * Des:直播
 **/
class LiveFragment : BaseFragment<FragLiveBinding, GoodsViewModel>() {
    companion object {
        fun newInstance(): LiveFragment = LiveFragment()
    }

    override fun getLayoutId(): Int = R.layout.frag_live

    override fun viewModelClass(): Class<GoodsViewModel> = GoodsViewModel::class.java
    override fun initData() {
        super.initData()
        val mDataList = mutableListOf<Any>()
        val imageUrls = arrayListOf(
            "https://n.sinaimg.cn/sinacn20190507s/110/w580h330/20190507/35f1-hwsffza5191997.jpg",
            "http://img.pconline.com.cn/images/upload/upc/tx/itbbs/1612/26/c7/33552955_1482716057239_mthumb.jpg",
            "http://n.sinaimg.cn/translate/20170331/oeBV-fycxmks4909917.jpg",
            "http://image.jisuxz.com/down/UploadPic/2017-6/20170620140411884.jpg",
            "http://5b0988e595225.cdn.sohucs.com/images/20171228/f6b9379b90164301a0ffddcacb4dc3f2.jpeg",
            "http://n.sinaimg.cn/translate/20170331/oeBV-fycxmks4909917.jpg"
        )
        for (i in 0..19) {
            val liveItemModel = LiveItemModel()
            liveItemModel.liveUrl.set(imageUrls[i % imageUrls.size])
            mDataList.add(liveItemModel)
        }
        mRootView.rv_live.adapter =
            RealRVAdapter(mDataList, RVTypeHelper().addAdapterType(LiveListAdapter()).get())
    }

    fun getRV(): RecyclerView {
        return mRootView.rv_live
    }
}