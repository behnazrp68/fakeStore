package com.rajabi.fakestoreapplication.presentation.di

import android.app.Application
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import com.rajabi.fakestoreapplication.domain.usecase.GetProductByIDUsecase
import com.rajabi.fakestoreapplication.domain.usecase.SaveProductUsecase
import com.rajabi.fakestoreapplication.presentation.viewmodel.FakeStoreViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Provides
    @Singleton
    fun provideCityViewModelFactory(
        app: Application,
        getAllProductsUsecase: GetAllProductsUsecase,
        saveProductUsecase: SaveProductUsecase,
        getProductByIDUsecase: GetProductByIDUsecase
    ): FakeStoreViewModelFactory {
        return FakeStoreViewModelFactory(
            app, getAllProductsUsecase, saveProductUsecase,
            getProductByIDUsecase
        )
    }

}
