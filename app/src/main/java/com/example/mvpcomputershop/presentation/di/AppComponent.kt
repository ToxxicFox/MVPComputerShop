package com.example.mvpcomputershop.presentation.di

import com.example.mvpcomputershop.presentation.activity.MainActivity
import com.example.mvpcomputershop.presentation.fragments.login.LoginFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        RepositoryModule::class,
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(fragment: LoginFragment)
}