package com.neworin.easyreading.ui.home.news

import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.neworin.easyreading.R
import com.neworin.easyreading.base.BaseRecyclerViewFragment
import com.neworin.easyreading.vo.NewsEntity
import com.neworin.easyreading.vo.PageResult
import kotlinx.android.synthetic.main.item_base_recyclerview.*
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
    private var mPageType = PAGE_TYPE_TECH

    companion object {
        //科技动态
        const val PAGE_TYPE_TECH = 0x001
        //开发者资讯
        const val PAGE_TYPE_DEV = 0x002
        //区块链快讯
        const val PAGE_TYPE_BLOCK_CHAIN = 0x003

        const val PAGE_TYPE_KEY = "page_type_key"

        fun newInstance(bundle: Bundle): NewsFragment {
            val fragment = NewsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initializeView(view: View) {
        super.initializeView(view)
        val bundle = arguments
        mPageType = bundle?.getInt(PAGE_TYPE_KEY, PAGE_TYPE_TECH) ?: PAGE_TYPE_TECH
        postData(false)
    }

    override fun getAdapter(): BaseQuickAdapter<NewsEntity, BaseViewHolder>? {
        return NewsAdapter(R.layout.item_news, mDatas)
    }

    override fun handleRefresh() {
        postData(true)
    }

    override fun handleLoadMore() {
        postData(false)
    }

    /**
     * 请求数据
     */
    private fun postData(isRefresh: Boolean) {
        mIsRefreshing = isRefresh
        when (mPageType) {
            PAGE_TYPE_TECH -> mPresenter?.getTechNewsData(mIsRefreshing)
            PAGE_TYPE_BLOCK_CHAIN -> mPresenter?.getBlockNewsData(mIsRefreshing)
            else -> mPresenter?.getDevNewsData(mIsRefreshing)
        }
    }

    override fun showData(data: PageResult<NewsEntity>?) {
        mDatas = data?.data as ArrayList<NewsEntity>
        if (mIsRefreshing) {
            mAdapter?.setNewData(mDatas)
            base_srl.post { base_srl.isRefreshing = false }
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