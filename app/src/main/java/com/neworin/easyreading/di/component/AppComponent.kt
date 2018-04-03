package com.neworin.easyreading.di.component

import com.neworin.easyreading.BaseApplication
import com.neworin.easyreading.di.module.ActivityBindingModule
import com.neworin.easyreading.di.module.ApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, ActivityBindingModule::class, ApiModule::class))
interface AppComponent {
    fun inject(application: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BaseApplication): Builder

        fun build(): AppComponent
    }
}