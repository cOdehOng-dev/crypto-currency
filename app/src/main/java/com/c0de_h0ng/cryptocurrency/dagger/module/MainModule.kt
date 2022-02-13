package com.c0de_h0ng.cryptocurrency.dagger.module

import com.c0de_h0ng.data.remote.api.BithumbApi
import com.c0de_h0ng.data.remote.api.CoinPaprikaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by c0de_h0ng on 2022/02/12.
 */
@Module
@InstallIn(ActivityComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(okHttpClient: OkHttpClient): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(CoinPaprikaApi.HOST_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBithumbApi(okHttpClient: OkHttpClient): BithumbApi {
        return Retrofit.Builder()
            .baseUrl(BithumbApi.HOST_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BithumbApi::class.java)
    }



}