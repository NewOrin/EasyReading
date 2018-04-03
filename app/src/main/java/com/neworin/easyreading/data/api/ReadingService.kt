package com.neworin.easyreading.data.api

import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.Flowable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   :
 */
interface ReadingService {

    @GET("topic")
    fun getTopicList(@Query("lastCursor") lastCursor: Int?, @Query(value = "pageSize",encoded = false) pageSize: Int): Flowable<TopicEntity>
}