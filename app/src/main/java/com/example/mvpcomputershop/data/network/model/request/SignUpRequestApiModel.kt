package com.example.mvpcomputershop.data.network.model.request

import com.google.gson.annotations.SerializedName

data class SignUpRequestApiModel(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("password_confirmation")
    val passwordConfirmation: String?,
)