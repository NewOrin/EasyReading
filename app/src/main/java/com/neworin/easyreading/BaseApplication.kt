package com.neworin.easyreading

import android.app.Application

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   :
 */
class BaseApplication : Application() {

    companion object {
        lateinit var INSTANCE: BaseApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}