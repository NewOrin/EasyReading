package com.neworin.easyreading.ui.home.topic

import com.neworin.easyreading.base.BasePresenter
import com.neworin.easyreading.data.ReadingRepository
import com.neworin.easyreading.utils.showToast
import com.neworin.easyreading.vo.PageResult
import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.functions.Consumer

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
class TopicPresenter(repository: ReadingRepository, rootView: TopicContract.View) : BasePresenter<ReadingRepository, TopicContract.View>(repository, rootView), TopicContract.Presenter {

    private var lastCursor: Int? = null
    private val PAGE_SIZE = 10

    override fun getTopicData(isRefresh: Boolean) {
        if (isRefresh) {
            lastCursor = null
        }
        mRepository.getTopicList(lastCursor, PAGE_SIZE)?.subscribe(object : Consumer<PageResult<TopicEntity>> {
            override fun accept(t: PageResult<TopicEntity>) {
                mView.showTopicData(t)
                lastCursor = t.data?.last()?.order
            }
        }, object : Consumer<Throwable> {
            override fun accept(t: Throwable?) {
                showToast(t?.message)
                mView.showTopicDataError()
            }
        })
    }
}