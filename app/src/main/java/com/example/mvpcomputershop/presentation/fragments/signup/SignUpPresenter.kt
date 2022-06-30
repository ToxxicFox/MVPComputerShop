package com.example.mvpcomputershop.presentation.fragments.signup

import android.util.Log
import com.example.mvpcomputershop.domain.usecases.profile.SignUpUseCase
import com.example.mvpcomputershop.presentation.model.mapper.SignUpUserMapper.toLoginEntity
import com.example.mvpcomputershop.presentation.model.signup.SignUpViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class SignUpPresenter @Inject constructor(
    private val signUpUseCase: SignUpUseCase
): MvpPresenter<ISignUpView>() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    fun signUp(signUpViewModel: SignUpViewModel){
        signUpUseCase.signUp(signUpViewModel.toLoginEntity())
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
                Log.e("SIGNUP", error.toString())
            }).let(compositeDisposable::add)
    }

}