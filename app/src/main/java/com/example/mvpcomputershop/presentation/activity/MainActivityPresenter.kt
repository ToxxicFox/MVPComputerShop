package com.example.mvpcomputershop.presentation.activity

import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainActivityPresenter(
    private val router: Router
): MvpPresenter<MainView>() {

    fun onBackPressed() {
        router.exit()
    }

}