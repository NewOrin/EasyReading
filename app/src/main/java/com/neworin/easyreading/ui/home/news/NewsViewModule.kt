package com.neworin.easyreading.ui.home.news

import dagger.Binds
import dagger.Module

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
@Module(includes = arrayOf(NewsPresenterModule::class))
abstract class NewsViewModule {

    @Binds
    abstract fun provideView(newsFragment: NewsFragment): NewsContract.View
}