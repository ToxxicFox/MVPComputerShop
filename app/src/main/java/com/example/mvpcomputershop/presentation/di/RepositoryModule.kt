package com.example.mvpcomputershop.presentation.di

import com.example.mvpcomputershop.data.network.api.AuthApi
import com.example.mvpcomputershop.data.network.api.ShopApi
import com.example.mvpcomputershop.data.repository.AuthorizationRepository
import com.example.mvpcomputershop.data.repository.CatalogRepository
import com.example.mvpcomputershop.domain.repository.IAuthRepository
import com.example.mvpcomputershop.domain.repository.ICatalogRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi): IAuthRepository = AuthorizationRepository(api)

    @Provides
    @Singleton
    fun provideCatalogRepository(api: ShopApi): ICatalogRepository = CatalogRepository(api)

}