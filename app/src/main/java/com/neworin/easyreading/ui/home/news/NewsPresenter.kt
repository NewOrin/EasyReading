package com.neworin.easyreading.ui.home.news

import com.neworin.easyreading.base.BasePresenter
import com.neworin.easyreading.data.ReadingRepository
import com.neworin.easyreading.utils.toDate

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
class NewsPresenter(repository: ReadingRepository, rootView: NewsContract.View) : BasePresenter<ReadingRepository, NewsContract.View>(repository, rootView), NewsContract.Presenter {

    private var lastCursor: Long? = null
    private val PAGE_SIZE = 10

    /**
     * 获取科技动态
     */
    override fun getTechNewsData(isRefresh: Boolean) {
        if (isRefresh) {
            lastCursor = null
        }
        val flowable = mRepository.getTechNewsList(lastCursor, PAGE_SIZE)
                ?.subscribe({
                    mView.showData(it)
                    lastCursor = it.data?.last()?.publishDate!!.toDate("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")?.time!!
                }, {
                    mView.showDataError(it)
                })
        addDispose(flowable)
    }

    /**
     * 获取开发者资讯
     */
    override fun getDevNewsData(isRefresh: Boolean) {
        if (isRefresh) {
            lastCursor = null
        }
        val flowable = mRepository.getDevNewsList(lastCursor, PAGE_SIZE)
                ?.subscribe({
                    mView.showData(it)
                    lastCursor = it.data?.last()?.publishDate!!.toDate("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")?.time!!
                }, {
                    mView.showDataError(it)
                })
        addDispose(flowable)
    }

    /**
     * 获取区块链快讯
     */
    override fun getBlockNewsData(isRefresh: Boolean) {
        if (isRefresh) {
            lastCursor = null
        }
        val flowable = mRepository.getBlockNewsList(lastCursor, PAGE_SIZE)
                ?.subscribe({
                    mView.showData(it)
                    lastCursor = it.data?.last()?.publishDate!!.toDate("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")?.time!!
                }, {
                    mView.showDataError(it)
                })
        addDispose(flowable)
    }
}