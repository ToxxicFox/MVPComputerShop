package com.example.mvpcomputershop.domain.usecases.profile

import com.example.mvpcomputershop.domain.entity.UserEntity
import com.example.mvpcomputershop.domain.repository.IAuthRepository

class SignUpUseCase(
    private val repository: IAuthRepository
) {
    fun signUp(user: UserEntity) = repository.signUp(user)
}