package com.goach.homesimple.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * author: Goach.zhong
 * Date: 2020-07-24 09:41
 * Des:BaseFragment
 **/
abstract class BaseFragment<B : ViewDataBinding, VM : BaseViewModel> : Fragment() {
    private var mViewModelProviderHelper: ViewModelProviderHelper = ViewModelProviderHelper()
    protected open lateinit var mViewDataBinding: B
    protected open lateinit var mViewModel: VM
    protected open lateinit var mFM:FragmentManager
    protected open lateinit var mRootView:View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFM = childFragmentManager
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bindView:View?
        mViewDataBinding = if (getLayoutId() > 0) {
            bindView = LayoutInflater.from(context).inflate(getLayoutId(),container,false)
            DataBindingUtil.bind(bindView)!!
        } else {
            bindView = getLayoutView()
            requireNotNull(bindView) { "getLayoutId and getLayoutView must override one" }
            DataBindingUtil.bind(bindView)!!
        }
        mRootView = bindView!!
        mViewModel = mViewModelProviderHelper.getFragmentVMProvider(this)!!.get(viewModelClass())
        initData()
        return bindView
    }
    abstract fun getLayoutId(): Int
    abstract fun viewModelClass(): Class<VM>
    protected open fun getLayoutView(): View? {
        return null
    }

    protected open fun initData() {}
}