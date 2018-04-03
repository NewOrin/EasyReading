package com.neworin.easyreading.ui.topic

import dagger.Binds
import dagger.Module

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
@Module(includes = arrayOf(TopicPresenterModule::class))
abstract class TopicViewModule {
    @Binds
    abstract fun provideView(topicFragment: TopicFragment): TopicContract.View
}