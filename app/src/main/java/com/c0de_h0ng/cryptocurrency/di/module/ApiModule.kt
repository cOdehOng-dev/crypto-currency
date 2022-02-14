package com.c0de_h0ng.cryptocurrency.di.module

import com.c0de_h0ng.cryptocurrency.Const
import com.c0de_h0ng.cryptocurrency.PrettyHttpLogging
import com.c0de_h0ng.data.remote.api.BithumbApi
import com.c0de_h0ng.data.remote.api.CoinPaprikaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by c0de_h0ng on 2022/02/12.
 */

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor(PrettyHttpLogging())
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttBuilder = OkHttpClient.Builder()
            .connectTimeout(Const.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(Const.WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(Const.READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(interceptor)

        return okHttBuilder.build()
    }

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