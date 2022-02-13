package com.c0de_h0ng.data.remote.dto.ticker

import com.c0de_h0ng.domain.model.Coin
import com.c0de_h0ng.domain.model.State
import com.google.gson.annotations.SerializedName

data class CoinTickerDto(
    @SerializedName("beta_value")
    val betaValue: Double,
    @SerializedName("circulating_supply")
    val circulatingSupply: Int,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    val id: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("max_supply")
    val maxSupply: Int,
    val name: String,
    @SerializedName("info")
    val info: Info,
    val rank: Int,
    val symbol: String,
    @SerializedName("total_supply")
    val totalSupply: Int
)

data class Info(
    @SerializedName("USD")
    val coinState: CoinState
)

data class CoinState(
    val ath_date: String,
    val ath_price: Double,
    @SerializedName("market_cap")
    val marketCap: Long, // 시가 총액
    val market_cap_change_24h: Double, // 시가 총액 변동율
    val percent_change_12h: Double,
    val percent_change_15m: Double,
    @SerializedName("percent_change_1h")
    val hourPerChange: Double,
    @SerializedName("percent_change_1y")
    val yearPerChange: Double,
    @SerializedName("percent_change_24h")
    val dayPerChange: Double,
    @SerializedName("percent_change_30d")
    val monthPerChange: Double,
    val percent_change_30m: Double,
    val percent_change_6h: Double,
    @SerializedName("percent_change_7d")
    val weekPerChange: Double,
    val percent_from_price_ath: Double, // 가격대비 백분율
    val price: Double,
    @SerializedName("volume_24h")
    val volume24h: Double, // 거래량
    @SerializedName("volume_24h_change_24h")
    val volume24hChange24h: Double // 거래량 변동율
)

fun CoinTickerDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        state = info.coinState.toState()
    )
}

fun CoinState.toState(): State {
    return State(
        price = price,
        volume24h = volume24h,
        marketCap = marketCap,
        hourPerChange= hourPerChange,
        dayPerChange = dayPerChange,
        weekPerChange = weekPerChange,
        monthPerChange = monthPerChange,
        yearPerChange = yearPerChange
    )
}



