package com.example.mvpcomputershop.presentation.di

import com.example.mvpcomputershop.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: App) {

    @Provides
    fun app(): App = app
}