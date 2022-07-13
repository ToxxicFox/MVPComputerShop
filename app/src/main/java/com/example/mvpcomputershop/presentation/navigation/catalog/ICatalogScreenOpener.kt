package com.example.mvpcomputershop.presentation.navigation.catalog

import com.github.terrakok.cicerone.Screen

interface ICatalogScreenOpener {
    fun openCatalogFragment(): Screen
    fun openProductFragment(): Screen
}