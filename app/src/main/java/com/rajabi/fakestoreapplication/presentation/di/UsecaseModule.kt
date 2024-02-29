package com.rajabi.fakestoreapplication.presentation.di

import com.rajabi.fakestoreapplication.domain.repository.StoreRepository
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import com.rajabi.fakestoreapplication.domain.usecase.GetProductByIDUsecase
import com.rajabi.fakestoreapplication.domain.usecase.SaveProductUsecase
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
        storeRepository: StoreRepository
    ): GetAllProductsUsecase {
        return GetAllProductsUsecase(storeRepository)
    }


    @Provides
    @Singleton
    fun provideGSaveProductUsecase(
        storeRepository: StoreRepository
    ): SaveProductUsecase {
        return SaveProductUsecase(storeRepository)
    }



    @Provides
    @Singleton
    fun provideGetProductByIdUsecase(
        storeRepository: StoreRepository
    ): GetProductByIDUsecase {
        return GetProductByIDUsecase(storeRepository)
    }
}
