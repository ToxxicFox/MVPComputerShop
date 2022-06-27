package com.example.mvpcomputershop.presentation.fragments.login


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvpcomputershop.domain.usecases.profile.LoginUseCase
import com.example.mvpcomputershop.presentation.model.login.LoginViewModel
import com.example.mvpcomputershop.presentation.model.mapper.LoginUserMapper.toLoginEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(
    private val loginUseCase: LoginUseCase
): MvpPresenter<ILoginView>() {

    private var userFromView: LoginViewModel? = null

    private var assignedToken: MutableLiveData<String> = MutableLiveData()
    val token: LiveData<String>
        get() = assignedToken

    fun getRequest(user: LoginViewModel) {
        userFromView = user
    }

    fun login() {
        val userRequest = userFromView
        val getToken = userRequest?.let { loginUseCase.login(it.toLoginEntity()) }
        getToken
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                { it ->
                    assignedToken.value = it
                }, {error ->
                    Log.e("LOGIN", error.toString())
                }
            )
    }

}