package com.neworin.easyreading.ui.topic

import android.view.View
import com.neworin.easyreading.R
import com.neworin.easyreading.base.BaseFragment
import com.neworin.easyreading.vo.TopicEntity
import kotlinx.android.synthetic.main.fragment_topic.*
import javax.inject.Inject

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
class TopicFragment : BaseFragment(), TopicContract.View {

    @JvmField
    @Inject
    var mPresenter: TopicContract.Presenter? = null

    override fun showTopicData(topicEntity: TopicEntity?) {
    }

    override fun initializeView(view: View) {
        super.initializeView(view)
        button.setOnClickListener({
            mPresenter?.getTopicData("", 20)
        })
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_topic
    }
}