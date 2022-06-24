package com.example.mvpcomputershop.data.mapper

import com.example.mvpcomputershop.data.network.model.request.LoginRequestApiModel
import com.example.mvpcomputershop.data.network.model.request.SignUpRequestApiModel
import com.example.mvpcomputershop.domain.entity.UserEntity

object ApiUserMapper{

    fun UserEntity.toLoginRequestApiModel(): LoginRequestApiModel {
        return with(this) {
            LoginRequestApiModel(
                email = email,
                password = password,
                deviceName = null,
            )
        }
    }

    fun UserEntity.toSignUpRequestApiModel(): SignUpRequestApiModel {
        return with(this) {
            SignUpRequestApiModel(
                email = email,
                password = password,
                passwordConfirmation = null,
            )
        }
    }

}