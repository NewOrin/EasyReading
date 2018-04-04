package com.neworin.easyreading.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neworin.easyreading.mvp.IView
import com.trello.rxlifecycle2.components.support.RxFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
abstract class BaseFragment : RxFragment(), IView, HasSupportFragmentInjector {

    open var hasFetchData: Boolean? = null
    open var mCompositeDisposable: CompositeDisposable? = null

    @JvmField
    @Inject
    var childFragmentInjector: DispatchingAndroidInjector<Fragment>? = null
    private var isViewPrepared: Boolean? = null
    open var mContainer: ViewGroup? = null

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return childFragmentInjector
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            readArguments(arguments!!)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContainer = container
        return inflater.inflate(getLayoutResId(), mContainer, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initializeView(view)
        isViewPrepared = true
        lazyFetchDataIfPrepared()
    }

    open fun initializeView(view: View) {}

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser)
            lazyFetchDataIfPrepared()
    }

    override fun onDestroyView() {
        isViewPrepared = false
        super.onDestroyView()
    }

    override fun onDestroy() {
        hasFetchData = false
        unDispose()
        super.onDestroy()
    }

    private fun lazyFetchDataIfPrepared() {
        if (hasFetchData != true && userVisibleHint && isViewPrepared == true) {
            hasFetchData = true
            fetchData()
        }
    }

    protected fun addDispose(disposable: Disposable) {
        mCompositeDisposable ?: CompositeDisposable()
        mCompositeDisposable?.add(disposable)
    }

    @CallSuper
    private fun unDispose() {
        mCompositeDisposable?.clear()
    }

    open fun fetchData() {}

    protected abstract fun getLayoutResId(): Int

    open fun readArguments(bundle: Bundle) {

    }
}