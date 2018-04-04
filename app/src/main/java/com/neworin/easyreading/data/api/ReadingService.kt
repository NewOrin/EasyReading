package com.neworin.easyreading.data.api

import com.neworin.easyreading.vo.NewsEntity
import com.neworin.easyreading.vo.PageResult
import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   :
 */
interface ReadingService {

    /**
     * 热门话题
     */
    @GET("topic")
    fun getTopicList(@Query("lastCursor") lastCursor: Int?, @Query(value = "pageSize", encoded = false) pageSize: Int): Flowable<PageResult<TopicEntity>>

    /**
     * 科技动态
     */
    @GET("news")
    fun getTechNewsList(@Query("lastCursor") lastCursor: Long?, @Query(value = "pageSize", encoded = false) pageSize: Int): Flowable<PageResult<NewsEntity>>

    /**
     * 开发者资讯
     */
    @GET("technews")
    fun getDevNewsList(@Query("lastCursor") lastCursor: Long?, @Query(value = "pageSize", encoded = false) pageSize: Int): Flowable<PageResult<NewsEntity>>

    /**
     * 区块链快讯
     */
    @GET("blockchain")
    fun getBlockNewsList(@Query("lastCursor") lastCursor: Long?, @Query(value = "pageSize", encoded = false) pageSize: Int): Flowable<PageResult<NewsEntity>>

}