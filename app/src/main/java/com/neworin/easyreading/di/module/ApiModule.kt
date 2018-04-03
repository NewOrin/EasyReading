package com.neworin.easyreading.di.module

import com.google.gson.GsonBuilder
import com.neworin.easyreading.data.ReadingRepository
import com.neworin.easyreading.data.api.ReadingService
import com.neworin.easyreading.http.DefaultOkHttpClient
import com.neworin.easyreading.utils.Constant
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * author : ZhangFubin
 * time   : 2018/04/02
 * desc   :
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return DefaultOkHttpClient.getOkHttpClient()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constant.BASE_READ_HUB_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ReadingService {
        return retrofit.create(ReadingService::class.java)
    }

    @Provides
    @Singleton
    fun provideReadingRepository(service: ReadingService): ReadingRepository {
        return ReadingRepository(service)
    }
}