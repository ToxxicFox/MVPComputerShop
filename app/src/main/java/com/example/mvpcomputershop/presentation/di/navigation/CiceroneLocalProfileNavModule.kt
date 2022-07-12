package com.example.mvpcomputershop.presentation.di.navigation

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
    @ProfileNavigation
    fun ciceroneProfile(): Cicerone<Router> = cicerone

    @Provides
    @ProfileNavigation
    fun navigatorTabProfileHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    @ProfileNavigation
    fun routerProfile(): Router = cicerone.router

    @Provides
    @ProfileNavigation
    @Singleton
    fun screenOpenProfile(): IProfileScreenOpener = ProfileScreenOpener()
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ProfileNavigation

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class FlowNavigation