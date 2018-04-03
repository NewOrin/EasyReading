package com.neworin.easyreading.ui.topic

import com.neworin.easyreading.base.BasePresenter
import com.neworin.easyreading.data.ReadingRepository
import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.functions.Consumer

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
class TopicPresenter(repository: ReadingRepository, rootView: TopicContract.View) : BasePresenter<ReadingRepository, TopicContract.View>(repository, rootView), TopicContract.Presenter {

    override fun getTopicData(lastCursor: String, pageSize: Int) {
        mRepository.getTopicList(lastCursor, pageSize)?.subscribe(object : Consumer<TopicEntity> {
            override fun accept(t: TopicEntity) {
                mView.showTopicData(t)
            }
        }, object : Consumer<Throwable> {
            override fun accept(t: Throwable?) {
            }
        })
    }
}