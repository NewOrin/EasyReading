package com.neworin.easyreading.base

import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.neworin.easyreading.BaseApplication
import com.neworin.easyreading.R
import kotlinx.android.synthetic.main.item_base_recyclerview.*

/**
 * author : ZhangFubin
 * time   : 2018/04/03
 * desc   :
 */
abstract class BaseRecyclerViewFragment<T, K : BaseViewHolder> : BaseFragment() {

    open var mAdapter: BaseQuickAdapter<T, K>? = null

    override fun getLayoutResId(): Int {
        return R.layout.item_base_recyclerview
    }

    override fun initializeView(view: View) {
        super.initializeView(view)
        base_rv.layoutManager = getLayoutManager()
        mAdapter = getAdapter()
        base_rv.adapter = mAdapter
        mAdapter?.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM)
        val emptyView = LayoutInflater.from(activity).inflate(R.layout.item_empty_view, mContainer, false)
//        mAdapter?.emptyView = emptyView
        base_srl.setColorSchemeColors(ContextCompat.getColor(BaseApplication.INSTANCE, R.color.colorAccent))
        base_srl.setOnRefreshListener {
            handleRefresh()
        }
        mAdapter?.setOnLoadMoreListener({ handleLoadMore() }, base_rv)
        emptyView.setOnClickListener {
            handleRefresh()
        }
    }

    open fun getLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(activity)
    }

    abstract fun getAdapter(): BaseQuickAdapter<T, K>?
    abstract fun handleRefresh()
    abstract fun handleLoadMore()
}