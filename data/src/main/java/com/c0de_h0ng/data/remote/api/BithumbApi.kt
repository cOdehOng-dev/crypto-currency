package com.c0de_h0ng.data.remote.api

import com.c0de_h0ng.data.remote.dto.bitthumb.BithumbCoinTicker
import com.c0de_h0ng.data.remote.model.BithumbResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by c0de_h0ng on 2022/02/12.
 */
interface BithumbApi {

    companion object {
        const val HOST_URL = "https://api.bithumb.com/public/"
    }



    @GET("ticker/all")
    fun getBithumbCoinTicker(): Call<BithumbResponse<BithumbCoinTicker>>




}