package com.goach.homesimple.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager

/**
 * author: Goach.zhong
 * Date: 2020-07-24 15:09
 * Des:BaseActivity
 **/
abstract class BaseActivity<B : ViewDataBinding, VM : BaseViewModel> : AppCompatActivity() {
    private var mViewModelProviderHelper: ViewModelProviderHelper = ViewModelProviderHelper()
    protected open lateinit var mViewDataBinding: B
    protected open lateinit var mViewModel: VM
    protected open lateinit var mFM:FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewDataBinding = if (getLayoutId() > 0) {
            DataBindingUtil.setContentView(this, getLayoutId())
        } else {
            val bindView = getLayoutView()
            requireNotNull(bindView) { "getLayoutId and getLayoutView must override one" }
            setContentView(bindView)
            DataBindingUtil.bind(bindView)!!
        }
        mFM = supportFragmentManager
        mViewModel = mViewModelProviderHelper.getActivityVMProvider(this)!!.get(viewModelClass())
        initData()
    }

    abstract fun getLayoutId(): Int
    abstract fun viewModelClass(): Class<VM>
    protected open fun getLayoutView(): View? {
        return null
    }

    protected open fun initData() {}
}