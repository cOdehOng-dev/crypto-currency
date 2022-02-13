package com.c0de_h0ng.domain.model

/**
 * Created by c0de_h0ng on 2022/02/13.
 */
data class Coin(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val state: State
)

// 거래량 / 시가 총액 (24 시간)
data class State(
    val price: Double,

    val volume24h: Double, // 거래량
    val marketCap: Long, // 시가 총액
    val hourPerChange: Double, // 1시간
    val dayPerChange: Double, // 24시간
    val weekPerChange: Double, // 주간
    val monthPerChange: Double, // 월간
    val yearPerChange: Double // 연간
)
