package com.example.mvpcomputershop

import android.app.Application
import com.example.mvpcomputershop.presentation.di.AppComponent
import com.example.mvpcomputershop.presentation.di.AppModule
import com.example.mvpcomputershop.presentation.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    companion object {
        var appInstance: App? = null
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}