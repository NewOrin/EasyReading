package com.neworin.easyreading.ui.home.news

import com.neworin.easyreading.base.BasePresenter
import com.neworin.easyreading.data.ReadingRepository

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
class NewsPresenter(repository: ReadingRepository, rootView: NewsContract.View) : BasePresenter<ReadingRepository, NewsContract.View>(repository, rootView), NewsContract.Presenter {

    private var lastCursor: Int? = null
    private val PAGE_SIZE = 10

    override fun getNewsData(isRefresh: Boolean) {
        if (isRefresh) {
            lastCursor = null
        }
        val flowable = mRepository.getNewsList(lastCursor, PAGE_SIZE)
                ?.subscribe({
                    mView.showData(it)
                }, {
                    mView.showDataError(it)
                })
        addDispose(flowable)
    }
}