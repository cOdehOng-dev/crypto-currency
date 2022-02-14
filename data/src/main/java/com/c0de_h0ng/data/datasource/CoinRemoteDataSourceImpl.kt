package com.c0de_h0ng.data.datasource

import com.c0de_h0ng.data.remote.api.BithumbApi
import com.c0de_h0ng.data.remote.api.CoinPaprikaApi
import com.c0de_h0ng.data.remote.dto.ticker.CoinTickerEntity
import javax.inject.Inject

/**
 * Created by c0de_h0ng on 2022/02/13.
 */
class CoinRemoteDataSourceImpl @Inject constructor(
    private val paprikaApi: CoinPaprikaApi,
    private val bithumbApi: BithumbApi
) : CoinRemoteDataSource {

    override suspend fun getCoinTickerList(): List<CoinTickerEntity> {
        return paprikaApi.getCoinTickerList()
    }
}