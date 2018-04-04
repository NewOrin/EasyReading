package com.neworin.easyreading.ui.home.topic

import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.neworin.easyreading.R
import com.neworin.easyreading.base.BaseRecyclerViewFragment
import com.neworin.easyreading.vo.PageResult
import com.neworin.easyreading.vo.TopicEntity
import kotlinx.android.synthetic.main.item_base_recyclerview.*
import javax.inject.Inject

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
class TopicFragment : BaseRecyclerViewFragment<TopicEntity, BaseViewHolder>(), TopicContract.View {

    private var mDatas = ArrayList<TopicEntity>()
    @JvmField
    @Inject
    var mPresenter: TopicContract.Presenter? = null
    private var mIsRefreshing = false
    private var mCurrentCounter = 0

    companion object {
        fun newInstance(bundle: Bundle): TopicFragment {
            val fragment = TopicFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getAdapter(): BaseQuickAdapter<TopicEntity, BaseViewHolder>? {
        return TopicAdapter(R.layout.item_topic, mDatas)
    }

    override fun showTopicData(dto: PageResult<TopicEntity>?) {
        mDatas = dto?.data as ArrayList<TopicEntity>
        if (mIsRefreshing) {
            mAdapter?.setNewData(mDatas)
        } else {
            if (mCurrentCounter == dto.totalItems) {
                mAdapter?.loadMoreEnd()
            } else {
                mAdapter?.addData(mDatas)
                mCurrentCounter = mAdapter?.data?.size ?: 0
                mAdapter?.loadMoreComplete()
            }
        }
    }

    override fun showTopicDataError() {
        if (mIsRefreshing) {
            mAdapter?.setNewData(null)
        } else {
            mAdapter?.loadMoreFail()
        }
    }

    override fun initializeView(view: View) {
        super.initializeView(view)
        mPresenter?.getTopicData(mIsRefreshing)
    }

    override fun handleRefresh() {
        mIsRefreshing = true
        mPresenter?.getTopicData(mIsRefreshing)
        base_srl.post { base_srl.isRefreshing = false }
    }

    override fun handleLoadMore() {
        mIsRefreshing = false
        mPresenter?.getTopicData(mIsRefreshing)
    }
}