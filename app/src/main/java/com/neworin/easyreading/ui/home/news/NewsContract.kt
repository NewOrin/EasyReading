package com.neworin.easyreading.ui.home.news

import com.neworin.easyreading.mvp.IPresenter
import com.neworin.easyreading.mvp.IRecyclerView
import com.neworin.easyreading.vo.NewsEntity

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
interface NewsContract {
    interface View : IRecyclerView<NewsEntity>

    interface Presenter : IPresenter {
        fun getTechNewsData(isRefresh: Boolean)
        fun getDevNewsData(isRefresh: Boolean)
    }
}