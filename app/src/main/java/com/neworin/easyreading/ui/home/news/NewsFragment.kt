package com.neworin.easyreading.ui.home.news

import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.neworin.easyreading.R
import com.neworin.easyreading.base.BaseRecyclerViewFragment
import com.neworin.easyreading.vo.NewsEntity
import com.neworin.easyreading.vo.PageResult
import javax.inject.Inject

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
class NewsFragment : BaseRecyclerViewFragment<NewsEntity, BaseViewHolder>(), NewsContract.View {

    @JvmField
    @Inject
    var mPresenter: NewsContract.Presenter? = null
    private var mIsRefreshing = false
    private var mCurrentCounter = 0
    private var mDatas = ArrayList<NewsEntity>()

    companion object {
        fun newInstance(bundle: Bundle): NewsFragment {
            val fragment = NewsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initializeView(view: View) {
        super.initializeView(view)
        mPresenter?.getNewsData(mIsRefreshing)
    }

    override fun getAdapter(): BaseQuickAdapter<NewsEntity, BaseViewHolder>? {
        return NewsAdapter(R.layout.item_home_list)
    }

    override fun handleRefresh() {
        mIsRefreshing = true
        mPresenter?.getNewsData(mIsRefreshing)
    }

    override fun handleLoadMore() {
        mIsRefreshing = false
        mPresenter?.getNewsData(mIsRefreshing)
    }

    override fun showData(data: PageResult<NewsEntity>?) {
        mDatas = data?.data as ArrayList<NewsEntity>
        if (mIsRefreshing) {
            mAdapter?.setNewData(mDatas)
        } else {
            if (mCurrentCounter == data.totalItems) {
                mAdapter?.loadMoreEnd()
            } else {
                mAdapter?.addData(mDatas)
                mCurrentCounter = mAdapter?.data?.size ?: 0
                mAdapter?.loadMoreComplete()
            }
        }
    }

    override fun showDataError(throwable: Throwable) {
        if (mIsRefreshing) {
            mAdapter?.setNewData(null)
        } else {
            mAdapter?.loadMoreFail()
        }
    }
}