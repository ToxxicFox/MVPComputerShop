package com.example.mvpcomputershop.presentation.navigation.cart

import com.github.terrakok.cicerone.Screen

interface ICartScreenOpener {
    fun openCartFragment(): Screen
    fun openOrderFragment(): Screen
}