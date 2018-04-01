package com.neworin.easyreading.http.transformer

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   : 默认线程调度
 */
class SchedulerTransformer<T> : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    companion object {
        fun <T> create(): SchedulerTransformer<T> {
            return SchedulerTransformer()
        }
    }
}
