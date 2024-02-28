package com.rajabi.fakestoreapplication.presentation.di

import androidx.room.Update
import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import com.rajabi.fakestoreapplication.domain.usecase.GetProductByIDUsecase
import com.rajabi.fakestoreapplication.domain.usecase.SaveProductUsecase
import com.rajabi.fakestoreapplication.domain.usecase.UpdateProductUsecase
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


    @Provides
    @Singleton
    fun provideGSaveProductUsecase(
        fakeStoreRepository: FakeStoreRepository
    ): SaveProductUsecase {
        return SaveProductUsecase(fakeStoreRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateProductsUsecase(
        fakeStoreRepository: FakeStoreRepository
    ): UpdateProductUsecase {
        return UpdateProductUsecase(fakeStoreRepository)
    }


    @Provides
    @Singleton
    fun provideGetProductByIdUsecase(
        fakeStoreRepository: FakeStoreRepository
    ): GetProductByIDUsecase {
        return GetProductByIDUsecase(fakeStoreRepository)
    }
}
