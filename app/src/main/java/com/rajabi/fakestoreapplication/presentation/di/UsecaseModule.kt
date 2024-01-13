package com.rajabi.fakestoreapplication.presentation.di

import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UsecaseModule {

    @Provides
    @Singleton
    fun provideGetAllProductsUsecase(
        fakeStoreRepository: FakeStoreRepository
    ): GetAllProductsUsecase {
        return GetAllProductsUsecase(fakeStoreRepository)
    }

}