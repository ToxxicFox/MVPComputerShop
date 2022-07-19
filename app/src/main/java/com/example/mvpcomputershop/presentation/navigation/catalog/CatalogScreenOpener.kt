package com.example.mvpcomputershop.presentation.navigation.catalog

import com.example.mvpcomputershop.presentation.fragments.catalog.CatalogFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

class CatalogScreenOpener : ICatalogScreenOpener {
    override fun openCatalogFragment(): Screen = FragmentScreen { CatalogFragment() }
    override fun openProductFragment(): Screen {
        TODO("Not yet implemented")
    }
}