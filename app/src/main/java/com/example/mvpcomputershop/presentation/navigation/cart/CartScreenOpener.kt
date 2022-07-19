package com.example.mvpcomputershop.presentation.navigation.cart

import com.example.mvpcomputershop.presentation.fragments.cart.CartFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class CartScreenOpener: ICartScreenOpener{
    override fun openCartFragment(): Screen = FragmentScreen { CartFragment() }

    override fun openOrderFragment(): Screen {
        TODO("Not yet implemented")
    }

}