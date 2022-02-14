package com.c0de_h0ng.data.repository

import com.c0de_h0ng.data.datasource.CoinRemoteDataSource
import com.c0de_h0ng.data.mapper.mapperToCoin
import com.c0de_h0ng.domain.model.CoinTicker
import com.c0de_h0ng.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * Created by c0de_h0ng on 2022/02/13.
 */
class CoinRepositoryImpl @Inject constructor(
    private val remoteData: CoinRemoteDataSource
) : CoinRepository {
    override suspend fun getCoinTickerList(): List<CoinTicker> {
        return mapperToCoin(remoteData.getCoinTickerList())
    }

}