package com.c0de_h0ng.domain.repository

import com.c0de_h0ng.domain.model.CoinTicker

/**
 * Created by c0de_h0ng on 2022/02/13.
 */
interface CoinRepository {
    suspend fun getCoinTickerList(): List<CoinTicker>
}