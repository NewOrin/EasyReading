package com.neworin.easyreading.ui.home.topic

import com.neworin.easyreading.mvp.IPresenter
import com.neworin.easyreading.mvp.IView
import com.neworin.easyreading.vo.TopicEntity

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
interface TopicContract {
    interface View : IView {
        fun showTopicData(topicEntity: TopicEntity?)
    }

    interface Presenter : IPresenter {
        fun getTopicData(lastCursor: String, pageSize: Int)
    }
}