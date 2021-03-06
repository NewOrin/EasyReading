package com.neworin.easyreading.data

import com.neworin.easyreading.mvp.IModel
import com.neworin.easyreading.vo.NewsEntity
import com.neworin.easyreading.vo.PageResult
import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.Flowable

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
interface ReadingDataSourse : IModel {
    fun getTopicList(lastCursor: Int?,pageSize: Int): Flowable<PageResult<TopicEntity>>?

    fun getTechNewsList(lastCursor: Long?, pageSize: Int): Flowable<PageResult<NewsEntity>>?

    fun getDevNewsList(lastCursor: Long?, pageSize: Int): Flowable<PageResult<NewsEntity>>?

    fun getBlockNewsList(lastCursor: Long?, pageSize: Int): Flowable<PageResult<NewsEntity>>?
}