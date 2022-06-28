package com.example.mvpcomputershop.presentation.di

import com.example.mvpcomputershop.data.repository.AuthorizationRepository
import com.example.mvpcomputershop.domain.repository.IAuthRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(): IAuthRepository = AuthorizationRepository()

}