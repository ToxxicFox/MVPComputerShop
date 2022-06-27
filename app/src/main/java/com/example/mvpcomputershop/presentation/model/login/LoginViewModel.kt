package com.example.mvpcomputershop.presentation.model.login

data class LoginViewModel(
    val email: String,
    val password: String,
    val deviceName: String? = android.os.Build.MODEL,
)