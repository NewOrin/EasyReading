package com.neworin.easyreading.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import com.neworin.easyreading.mvp.IView
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
abstract class BaseActivity :RxAppCompatActivity(),IView{

    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
    }
    protected fun initializeView(){}

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initializeView()
    }
}