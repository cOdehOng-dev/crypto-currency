package com.c0de_h0ng.data.remote.dto.bitthumb

data class BithumbCoinTicker(
    val response: Map<String, Ticker>
) {
    fun getCoinName() {
        response.forEach { (k, v) -> println("key : $k, value : $v")  }
//        response.forEach {
//            Log.d("ResultName", it.key ?: "null")
//        }
    }

}