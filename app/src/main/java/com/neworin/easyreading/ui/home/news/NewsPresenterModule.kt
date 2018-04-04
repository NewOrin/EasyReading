package com.neworin.easyreading.ui.home.news

import com.neworin.easyreading.data.ReadingRepository
import dagger.Module
import dagger.Provides

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
@Module
class NewsPresenterModule {

    @Provides
    fun providePresenter(repository: ReadingRepository, view: NewsContract.View): NewsContract.Presenter {
        return NewsPresenter(repository, view)
    }
}