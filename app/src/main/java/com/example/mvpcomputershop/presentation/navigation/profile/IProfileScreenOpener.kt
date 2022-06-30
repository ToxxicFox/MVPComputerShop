package com.example.mvpcomputershop.presentation.navigation.profile

import com.github.terrakok.cicerone.Screen

interface IProfileScreenOpener {
    fun openLoginFragment(): Screen
    fun openSignUpFragment(): Screen
    fun openProfileFragment(): Screen
}