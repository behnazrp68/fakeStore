package com.rajabi.fakestoreapplication.presentation.di


import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository
import com.rajabi.fakestoreapplication.repository.FakeStoreRepositoryImpl
import com.rajabi.fakestoreapplication.repository.datasource.FakeStoreRemoteDataSource
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
        fakeStoreRemoteDataSource: FakeStoreRemoteDataSource
    ): FakeStoreRepository {
        return FakeStoreRepositoryImpl(fakeStoreRemoteDataSource)
    }
}