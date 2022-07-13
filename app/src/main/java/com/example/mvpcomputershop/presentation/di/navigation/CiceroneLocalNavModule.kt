package com.example.mvpcomputershop.presentation.di.navigation

import com.example.mvpcomputershop.presentation.navigation.cart.CartScreenOpener
import com.example.mvpcomputershop.presentation.navigation.cart.ICartScreenOpener
import com.example.mvpcomputershop.presentation.navigation.catalog.CatalogScreenOpener
import com.example.mvpcomputershop.presentation.navigation.catalog.ICatalogScreenOpener
import com.example.mvpcomputershop.presentation.navigation.profile.IProfileScreenOpener
import com.example.mvpcomputershop.presentation.navigation.profile.ProfileScreenOpener
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class CiceroneLocalProfileNavModule {

    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @FlowNavigation
    fun ciceroneProfile(): Cicerone<Router> = cicerone

    @Provides
    @FlowNavigation
    fun navigatorTabProfileHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    @FlowNavigation
    fun routerProfile(): Router = cicerone.router

    @Provides
    @FlowNavigation
    @Singleton
    fun screenOpenProfile(): IProfileScreenOpener = ProfileScreenOpener()

    @Provides
    @FlowNavigation
    @Singleton
    fun screenOpenCatalog(): ICatalogScreenOpener = CatalogScreenOpener()

    @Provides
    @FlowNavigation
    @Singleton
    fun screenOpenCart(): ICartScreenOpener = CartScreenOpener()
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FlowNavigation