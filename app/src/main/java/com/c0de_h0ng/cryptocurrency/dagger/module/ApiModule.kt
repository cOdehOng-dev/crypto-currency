package com.c0de_h0ng.cryptocurrency.dagger.module

import com.c0de_h0ng.cryptocurrency.Const
import com.c0de_h0ng.cryptocurrency.PrettyHttpLogging
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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



}