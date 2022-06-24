package com.example.mvpcomputershop.presentation.fragments.login


import com.example.mvpcomputershop.domain.usecases.profile.LoginUseCase
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(
    private val loginUseCase: LoginUseCase
): MvpPresenter<ILoginView>() {

    fun login() {
    }

}