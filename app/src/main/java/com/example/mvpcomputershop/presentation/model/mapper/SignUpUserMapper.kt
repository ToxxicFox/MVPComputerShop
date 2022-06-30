package com.example.mvpcomputershop.presentation.model.mapper

import com.example.mvpcomputershop.domain.entity.UserEntity
import com.example.mvpcomputershop.presentation.model.signup.SignUpViewModel

object SignUpUserMapper {
    fun SignUpViewModel.toLoginEntity(): UserEntity {
        return with(this) {
            UserEntity(
                email = email,
                password = password,
                confirmPassword = confirmPassword,
            )
        }
    }
}