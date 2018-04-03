package com.neworin.easyreading.ui.home.topic

import com.neworin.easyreading.data.ReadingRepository
import dagger.Module
import dagger.Provides

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
@Module
class TopicPresenterModule {

    @Provides
    fun providePresenter(repository: ReadingRepository, view: TopicContract.View): TopicContract.Presenter {
        return TopicPresenter(repository, view)
    }
}