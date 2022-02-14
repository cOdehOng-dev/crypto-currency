package com.c0de_h0ng.data.datasource

import com.c0de_h0ng.data.remote.dto.ticker.CoinTickerEntity

/**
 * Created by c0de_h0ng on 2022/02/13.
 */
interface CoinRemoteDataSource {

    suspend fun getCoinTickerList(): List<CoinTickerEntity>
}