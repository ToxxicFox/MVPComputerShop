package com.example.mvpcomputershop.presentation.fragments.login


import android.util.Log
import com.example.mvpcomputershop.domain.usecases.profile.LoginUseCase
import com.example.mvpcomputershop.presentation.model.login.LoginViewModel
import com.example.mvpcomputershop.presentation.model.mapper.LoginUserMapper.toLoginEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class LoginPresenter @Inject constructor(
    private val loginUseCase: LoginUseCase
) : MvpPresenter<ILoginView>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    fun login(loginViewModel: LoginViewModel) {
        loginUseCase.login(loginViewModel.toLoginEntity())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                // show loader
            }
            .doFinally {
                // hide loader
            }
            .subscribe({
                viewState.showMessage(it)
            }, { error ->
                error.printStackTrace()
                Log.e("LOGIN", error.toString())
            }).let(compositeDisposable::add)
    }

}