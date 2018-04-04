package com.neworin.easyreading.ui.home.news

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : ZhangFubin
 * time   : 2018/04/04
 * desc   :
 */
@Module
abstract class NewsBindingModule {

    @ContributesAndroidInjector(modules = arrayOf(NewsBindingModule::class))
    abstract fun contributeNewsFragment(): NewsFragment
}