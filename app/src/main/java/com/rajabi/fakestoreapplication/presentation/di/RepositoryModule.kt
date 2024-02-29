package com.rajabi.fakestoreapplication.presentation.di


import com.rajabi.fakestoreapplication.domain.repository.StoreRepository
import com.rajabi.fakestoreapplication.data.repository.StoreRepositoryImpl
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreRemoteDataSource
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideDivarRepository(
        storeRemoteDataSource: StoreRemoteDataSource,
        satoreLocalDataSource: StoreLocalDataSource
    ): StoreRepository {
        return StoreRepositoryImpl(
            storeRemoteDataSource, satoreLocalDataSource
        )
    }
}