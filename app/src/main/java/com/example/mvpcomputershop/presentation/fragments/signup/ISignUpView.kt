package com.example.mvpcomputershop.presentation.fragments.signup

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ISignUpView: MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(token: String)
}