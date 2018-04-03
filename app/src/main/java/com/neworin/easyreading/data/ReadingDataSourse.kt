package com.neworin.easyreading.data

import com.neworin.easyreading.mvp.IModel
import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.Flowable

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
interface ReadingDataSourse : IModel {

    fun getTopicList(lastCursor: String, pageSize: Int): Flowable<TopicEntity>?
}