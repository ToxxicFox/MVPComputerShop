package com.example.mvpcomputershop.presentation.di

import com.example.mvpcomputershop.presentation.activity.MainActivity
import com.example.mvpcomputershop.presentation.di.navigation.CiceroneLocalProfileNavModule
import com.example.mvpcomputershop.presentation.di.navigation.CiceroneModule
import com.example.mvpcomputershop.presentation.fragments.cart.flow.CartFragmentFlowNavigationFragment
import com.example.mvpcomputershop.presentation.fragments.catalog.CatalogFragment
import com.example.mvpcomputershop.presentation.fragments.catalog.flow.CatalogFlowNavigationFragment
import com.example.mvpcomputershop.presentation.fragments.login.LoginFragment
import com.example.mvpcomputershop.presentation.fragments.login.flow.ProfileFlowNavigationFragment
import com.example.mvpcomputershop.presentation.fragments.signup.SignUpFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        CiceroneLocalProfileNavModule::class,
        RepositoryModule::class,
        NetworkModule::class,
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: SignUpFragment)
    fun inject(fragment: CatalogFragment)
    fun inject(fragment: ProfileFlowNavigationFragment)
    fun inject(fragment: CatalogFlowNavigationFragment)
    fun inject(fragment: CartFragmentFlowNavigationFragment)
}