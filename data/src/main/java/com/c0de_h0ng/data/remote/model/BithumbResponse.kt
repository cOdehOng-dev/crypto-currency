package com.c0de_h0ng.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by c0de_h0ng on 2022/02/12.
 */
data class BithumbResponse<T>(
    @SerializedName("data")
    val data: T,
    @SerializedName("status")
    val status: String
) {

    data class ListResponse<T2>(
        val list: List<T2>?
    )
}
