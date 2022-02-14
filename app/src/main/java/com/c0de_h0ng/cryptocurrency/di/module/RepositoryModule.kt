package com.c0de_h0ng.cryptocurrency.di.module

import com.c0de_h0ng.data.datasource.CoinRemoteDataSource
import com.c0de_h0ng.data.repository.CoinRepositoryImpl
import com.c0de_h0ng.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by c0de_h0ng on 2022/02/14.
 * https://leveloper.tistory.com/205
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinRepository(remoteDataSource: CoinRemoteDataSource): CoinRepository {
        return CoinRepositoryImpl(remoteDataSource)
    }

}