package com.neworin.easyreading.http

import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   :
 */
interface ApiService {

    @GET("topic")
    fun getTopicList(@Query("lastCursor") lastCursor: String, @Query(" pageSize ") pageSize: Int): Flowable<TopicEntity>
}