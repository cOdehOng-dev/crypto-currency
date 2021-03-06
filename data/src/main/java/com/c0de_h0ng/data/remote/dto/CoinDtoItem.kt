package com.c0de_h0ng.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CoinDtoItem(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)
