package com.neworin.easyreading

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.facebook.stetho.Stetho
import com.neworin.easyreading.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   :
 */
class BaseApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    companion object {
        lateinit var INSTANCE: BaseApplication
    }

    @Inject
    @JvmField
    var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    @Inject
    @JvmField
    var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>? = null

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        DaggerAppComponent.builder().application(this).build().inject(this)
        Stetho.initializeWithDefaults(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return dispatchingFragmentInjector
    }

}