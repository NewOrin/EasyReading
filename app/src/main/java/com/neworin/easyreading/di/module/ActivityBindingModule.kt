package com.neworin.easyreading.di.module

import com.neworin.easyreading.ui.home.topic.TopicBindingModule
import dagger.Module

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
@Module(includes = arrayOf(TopicBindingModule::class))
abstract class ActivityBindingModule {
}