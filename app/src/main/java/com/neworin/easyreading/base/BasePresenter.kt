package com.neworin.easyreading.base

import com.neworin.easyreading.mvp.IModel
import com.neworin.easyreading.mvp.IPresenter
import com.neworin.easyreading.mvp.IView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
open class BasePresenter<M : IModel, V : IView>(var mRepository: M,var mView: V) : IPresenter {

    protected var mCompositeDispose: CompositeDisposable? = null

    protected fun addDispose(disposable: Disposable) {
        if (mCompositeDispose == null) {
            mCompositeDispose = CompositeDisposable()
        }
        mCompositeDispose?.add(disposable)
    }

    override fun unDispose() {
        mCompositeDispose?.clear()
    }
}