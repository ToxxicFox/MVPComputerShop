package com.example.mvpcomputershop.domain.repository

import com.example.mvpcomputershop.domain.entity.UserEntity
import io.reactivex.rxjava3.core.Single

interface IAuthRepository {
    fun signUp(user: UserEntity): Single<String>
    fun login(user: UserEntity): Single<String>
}