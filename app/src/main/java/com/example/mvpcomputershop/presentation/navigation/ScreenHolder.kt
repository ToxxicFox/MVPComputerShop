package com.example.mvpcomputershop.presentation.navigation

import com.example.mvpcomputershop.presentation.fragments.cart.CartFragment
import com.example.mvpcomputershop.presentation.fragments.catalog.CatalogFragment
import com.example.mvpcomputershop.presentation.fragments.profile.ProfileFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ScreenHolder : IScreenHolder {
    override fun openCatalogFragment() = FragmentScreen { CatalogFragment() }
    override fun openCartFragment() = FragmentScreen { CartFragment() }
    override fun openProfileFragment() = FragmentScreen { ProfileFragment() }
}