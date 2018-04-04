package com.neworin.easyreading.ui.home.topic

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter.SLIDEIN_BOTTOM
import com.chad.library.adapter.base.BaseViewHolder
import com.neworin.easyreading.R
import com.neworin.easyreading.base.BaseFragment
import com.neworin.easyreading.base.BaseRecyclerViewFragment
import com.neworin.easyreading.vo.TopicEntity
import kotlinx.android.synthetic.main.fragment_topic.*
import kotlinx.android.synthetic.main.item_base_recyclerview.*
import javax.inject.Inject

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
class TopicFragment : BaseRecyclerViewFragment<TopicEntity.DataBean, BaseViewHolder>(), TopicContract.View {

    private var mDatas = ArrayList<TopicEntity.DataBean>()
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

    override fun getAdapter(): BaseQuickAdapter<TopicEntity.DataBean, BaseViewHolder>? {
        return TopicAdapter(R.layout.item_topic, mDatas)
    }

    override fun showTopicData(topicEntity: TopicEntity?) {
        mDatas = topicEntity?.data as ArrayList<TopicEntity.DataBean>
        if (mIsRefreshing) {
            mAdapter?.setNewData(mDatas)
        } else {
            if (mCurrentCounter == topicEntity.totalItems) {
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