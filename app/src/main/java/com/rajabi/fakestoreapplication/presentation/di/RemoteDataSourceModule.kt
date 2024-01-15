package com.rajabi.fakestoreapplication.presentation.di

import com.rajabi.fakestoreapplication.data.api.FakeStoreAPIServices
import com.rajabi.fakestoreapplication.data.repository.datasource.FakeStoreRemoteDataSource
import com.rajabi.fakestoreapplication.data.repository.datasourceimpl.FakeStoreRemoteDataSourceImpl
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
    fun provideProductsRemoteDataSource(fakeStoreAPIServices: FakeStoreAPIServices): FakeStoreRemoteDataSource {
        return FakeStoreRemoteDataSourceImpl(fakeStoreAPIServices)
    }
}