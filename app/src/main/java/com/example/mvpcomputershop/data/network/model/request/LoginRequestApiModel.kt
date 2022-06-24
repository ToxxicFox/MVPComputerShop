package com.example.mvpcomputershop.data.network.model.request

import com.google.gson.annotations.SerializedName

data class LoginRequestApiModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("device_name")
    val deviceName: String?,
)