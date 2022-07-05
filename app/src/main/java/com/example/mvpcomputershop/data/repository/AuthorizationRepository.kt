package com.example.mvpcomputershop.data.repository

import com.example.mvpcomputershop.data.mapper.ApiUserMapper.toLoginRequestApiModel
import com.example.mvpcomputershop.data.mapper.ApiUserMapper.toSignUpRequestApiModel
import com.example.mvpcomputershop.data.network.api.AuthApi
import com.example.mvpcomputershop.domain.entity.UserEntity
import com.example.mvpcomputershop.domain.repository.IAuthRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class AuthorizationRepository @Inject constructor(
    private val api: AuthApi
) : IAuthRepository {

    override fun signUp(user: UserEntity): Single<String> {
        return api.signUp(user.toSignUpRequestApiModel())
    }

    override fun login(user: UserEntity): Single<String> {
        return api.login(user.toLoginRequestApiModel())
    }
}