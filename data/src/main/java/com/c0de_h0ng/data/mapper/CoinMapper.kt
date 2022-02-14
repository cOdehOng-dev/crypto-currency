package com.c0de_h0ng.data.mapper

import com.c0de_h0ng.data.remote.dto.ticker.CoinTickerEntity
import com.c0de_h0ng.domain.model.CoinTicker
import com.c0de_h0ng.domain.model.State

/**
 * Created by c0de_h0ng on 2022/02/14.
 */

// data -> domain
fun mapperToCoin(coinEntityList: List<CoinTickerEntity>): List<CoinTicker> {

    return coinEntityList.toList().map { entity ->
        val state = State(
            price = entity.info.coinState.price,
            volume24h = entity.info.coinState.volume24h,
            marketCap = entity.info.coinState.marketCap,
            hourPerChange= entity.info.coinState.hourPerChange,
            dayPerChange = entity.info.coinState.dayPerChange,
            weekPerChange = entity.info.coinState.weekPerChange,
            monthPerChange = entity.info.coinState.monthPerChange,
            yearPerChange = entity.info.coinState.yearPerChange
        )
        CoinTicker(
            id = entity.id,
            rank = entity.rank,
            name = entity.name,
            symbol = entity.symbol,
            state = state
        )
    }
}

// domain -> data
//fun mapperToCoinEntity(coinTickerList: List<CoinTicker>): List<CoinTickerEntity> {
//    return coinTickerList.toList().map {
//        CoinTickerEntity(
//            it.id,
//
//        )
//    }
//}


//private fun CoinState.toState(): State {
//    return State(
//        price = price,
//        volume24h = volume24h,
//        marketCap = marketCap,
//        hourPerChange= hourPerChange,
//        dayPerChange = dayPerChange,
//        weekPerChange = weekPerChange,
//        monthPerChange = monthPerChange,
//        yearPerChange = yearPerChange
//    )
//}