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
        mAdapter?.addData(mDatas)
    }

    override fun initializeView(view: View) {
        super.initializeView(view)
        mPresenter?.getTopicData()
    }

    override fun handleRefresh() {
        mPresenter?.getTopicData()
    }
}