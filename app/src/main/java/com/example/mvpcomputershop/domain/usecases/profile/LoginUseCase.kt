package com.example.mvpcomputershop.domain.usecases.profile

import com.example.mvpcomputershop.domain.entity.UserEntity
import com.example.mvpcomputershop.domain.repository.IAuthRepository

class LoginUseCase(
    private val repository: IAuthRepository
) {
    fun login(user: UserEntity) = repository.login(user)
}