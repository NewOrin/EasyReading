package com.neworin.easyreading.data

import com.neworin.easyreading.data.api.ReadingService
import com.neworin.easyreading.vo.TopicEntity
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   :
 */
@Singleton
class ReadingRepository(service: ReadingService?) : ReadingDataSourse {
    private var mReadingService = service

    override fun getTopicList(lastCursor: String, pageSize: Int): Flowable<TopicEntity>? {
        return doRequest(mReadingService?.getTopicList(lastCursor, pageSize))
    }

    private fun <RESPONSE> doRequest(request: Flowable<RESPONSE>?): Flowable<RESPONSE>? {
        return request
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
    }
}