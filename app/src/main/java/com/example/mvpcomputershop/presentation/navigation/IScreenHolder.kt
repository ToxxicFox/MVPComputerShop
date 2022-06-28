package com.example.mvpcomputershop.presentation.navigation

import com.github.terrakok.cicerone.Screen

interface IScreenHolder {
    fun openCatalogFragment(): Screen
    fun openCartFragment(): Screen
    fun openProfileFragment(): Screen
}