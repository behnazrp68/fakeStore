package com.rajabi.fakestoreapplication.presentation.di

import com.rajabi.fakestoreapplication.data.api.StoreAPIServices
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreRemoteDataSource
import com.rajabi.fakestoreapplication.data.repository.datasourceimpl.StoreRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {
    @Singleton
    @Provides
    fun provideProductsRemoteDataSource(storeAPIServices: StoreAPIServices): StoreRemoteDataSource {
        return StoreRemoteDataSourceImpl(storeAPIServices)
    }
}