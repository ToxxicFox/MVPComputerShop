package com.example.mvpcomputershop.domain.entity

data class UserEntity(
    val email: String,
    val password: String,
    val deviceName: String?,
    val confirmPassword: String?
)