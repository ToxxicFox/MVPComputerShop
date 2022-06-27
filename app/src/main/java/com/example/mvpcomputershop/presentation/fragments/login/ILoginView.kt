package com.example.mvpcomputershop.presentation.fragments.login

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface ILoginView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showMessage(token: String)
}