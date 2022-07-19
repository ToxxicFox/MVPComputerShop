package com.example.mvpcomputershop.presentation.navigation.main

import com.example.mvpcomputershop.presentation.fragments.cart.flow.CartFragmentFlowNavigationFragment
import com.example.mvpcomputershop.presentation.fragments.catalog.flow.CatalogFlowNavigationFragment
import com.example.mvpcomputershop.presentation.fragments.login.flow.ProfileFlowNavigationFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object ScreenFactory {
    fun createTab(tab: TabKeys) = FragmentScreen {
        when(tab) {
            TabKeys.CATALOG -> {
                CatalogFlowNavigationFragment()
            }
            TabKeys.PROFILE -> {
                ProfileFlowNavigationFragment()
            }
            TabKeys.CART -> {
                CartFragmentFlowNavigationFragment()
            }
        }
    }
}