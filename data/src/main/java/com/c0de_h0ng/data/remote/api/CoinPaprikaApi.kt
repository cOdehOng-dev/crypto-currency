package com.c0de_h0ng.data.remote.api

import com.c0de_h0ng.data.remote.dto.ticker.CoinTickerEntity
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by c0de_h0ng on 2022/02/12.
 */
interface CoinPaprikaApi {

    companion object {
        const val HOST_URL = "https://api.coinpaprika.com/"
    }


    @GET("v1/tickers")
    suspend fun getCoinTickerList(): List<CoinTickerEntity>


    @GET("v1/tickers/{coin_id}")
    suspend fun getCoinTicker(@Path("coin_id") coinId: String): CoinTickerEntity

}