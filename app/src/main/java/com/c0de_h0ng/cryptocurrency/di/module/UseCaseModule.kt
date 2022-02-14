package com.c0de_h0ng.cryptocurrency.di.module

import com.c0de_h0ng.domain.repository.CoinRepository
import com.c0de_h0ng.domain.usecase.GetCoinsRankUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by c0de_h0ng on 2022/02/14.
 */
@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetCoinRankUseCase(repository: CoinRepository): GetCoinsRankUseCase {
        return GetCoinsRankUseCase(repository)
    }
}