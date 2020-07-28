package com.goach.homesimple.view

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.NestedScrollingParent2
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * author: Goach.zhong
 * Date: 2020-07-24 10:38
 * Des:滚动嵌套处理
 **/
class SmoothScrollLayout : ConstraintLayout, NestedScrollingParent2 {
    private var mAxes: Int? = null
    private var mBorderView: View? = null
    private var mParentRV: RecyclerView? = null
    private var mChildRV: RecyclerView? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onNestedScrollAccepted(child: View, target: View, axes: Int, type: Int) {
        mAxes = axes
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        for (index in 0 until childCount) {
            val child = getChildAt(index)
            if (child is RecyclerView) {
                mParentRV = child
            }
        }
    }

    /**
     * 设置父RecyclerView
     */
    fun setParentRV(parent: RecyclerView) {
        this.mParentRV = parent
    }

    fun setBorderView(borderView: View?){
        this.mBorderView = borderView
        Log.d("zgx","setBorderView=====${mBorderView}")
    }

    fun setChildRV(child: RecyclerView?) {
        this.mChildRV = child
    }

    override fun onStartNestedScroll(child: View, target: View, axes: Int, type: Int): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedPreScroll(target: View, dx: Int, dy: Int, consumed: IntArray, type: Int) {
        if (mBorderView == null) {
            return
        }
        if (target === mParentRV) {
            parentScroll(mBorderView!!.top, dy, consumed)
        } else {
            childScroll(mBorderView!!.top, dy, consumed)
        }
    }

    override fun onNestedScroll(
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int
    ) {
    }

    override fun onStopNestedScroll(target: View, type: Int) {
        mAxes = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            View.SCROLL_AXIS_NONE
        } else {
            0
        }
    }

    override fun getNestedScrollAxes(): Int {
        return mAxes!!
    }

    private fun parentScroll(childTop: Int, dy: Int, consumed: IntArray) {
        if (childTop == 0) {
            if (dy > 0 && mChildRV != null) {//向下滑动，滚动子RecyclerView
                consumed[1] = dy//父布局消费的滚动距离
                mChildRV!!.scrollBy(0, dy)

            } else {
                if (mChildRV != null && mChildRV!!.canScrollVertically(dy)) {//向上滑动，滚动子RecyclerView
                    consumed[1] = dy
                    mChildRV!!.scrollBy(0, dy)
                }
            }
        } else {
            if (childTop < dy) {
                consumed[1] = dy - childTop
            }
        }
    }

    private fun childScroll(childTop: Int, dy: Int, consumed: IntArray) {
        if (childTop == 0) {
            if (dy < 0) {
                if (mChildRV != null && !mChildRV!!.canScrollVertically(dy)) {
                    consumed[1] = dy
                    mParentRV?.scrollBy(0, dy)
                }
            }
        } else {
            if (dy < 0 || childTop > dy) {//向上滑动
                consumed[1] = dy
                mParentRV?.scrollBy(0, dy)
            } else {//向下滑动
                consumed[1] = dy
                mParentRV?.scrollBy(0, childTop)
            }
        }
    }
}