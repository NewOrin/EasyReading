package com.neworin.easyreading.mvp

import com.neworin.easyreading.vo.PageResult

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
interface IRecyclerView<T> : IView {

    fun showData(data: PageResult<T>?)

    fun showDataError(throwable: Throwable)
}