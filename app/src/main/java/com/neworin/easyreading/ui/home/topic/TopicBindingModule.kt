package com.neworin.easyreading.ui.home.topic

import com.neworin.easyreading.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
@Module
abstract class TopicBindingModule {
    @ContributesAndroidInjector
    abstract fun homeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = arrayOf(TopicViewModule::class))
    abstract fun contributeTopicFragment(): TopicFragment
}