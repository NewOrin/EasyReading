package com.neworin.easyreading.http

import com.google.gson.GsonBuilder
import com.neworin.easyreading.utils.Constant
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * author : ZhangFubin
 * time   : 2018/01/08
 * desc   :
 */
object RetrofitFactory {

    fun createRetrofit(): ApiService {
        return Retrofit.Builder()
                .baseUrl(Constant.BASE_READ_HUB_URL)
                .client(DefaultOkHttpClient.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiService::class.java)
    }
}