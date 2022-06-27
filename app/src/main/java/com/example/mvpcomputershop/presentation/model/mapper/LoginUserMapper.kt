package com.example.mvpcomputershop.presentation.model.mapper

import com.example.mvpcomputershop.domain.entity.UserEntity
import com.example.mvpcomputershop.presentation.model.login.LoginViewModel

object LoginUserMapper {
    fun LoginViewModel.toLoginEntity(): UserEntity {
        return with(this) {
            UserEntity(
                email = email,
                password = password,
                deviceName = deviceName,
            )
        }
    }
}