package com.rajabi.fakestoreapplication.presentation.di

import com.rajabi.fakestoreapplication.data.db.ProductDao
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreLocalDataSource
import com.rajabi.fakestoreapplication.data.repository.datasourceimpl.StoreLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun providesProductLocalDataSource(productDao: ProductDao): StoreLocalDataSource {
        return StoreLocalDataSourceImpl(productDao)
    }
}