package com.c0de_h0ng.cryptocurrency.di.module

import com.c0de_h0ng.data.datasource.CoinRemoteDataSource
import com.c0de_h0ng.data.datasource.CoinRemoteDataSourceImpl
import com.c0de_h0ng.data.remote.api.BithumbApi
import com.c0de_h0ng.data.remote.api.CoinPaprikaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by c0de_h0ng on 2022/02/14.
 */
@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideCoinRemoteDataSource(paprikaApi: CoinPaprikaApi, bithumbApi: BithumbApi): CoinRemoteDataSource {
        return CoinRemoteDataSourceImpl(paprikaApi, bithumbApi)
    }

}