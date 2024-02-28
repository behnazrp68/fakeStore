package com.rajabi.fakestoreapplication.presentation.di


import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository
import com.rajabi.fakestoreapplication.data.repository.FakeStoreRepositoryImpl
import com.rajabi.fakestoreapplication.data.repository.datasource.FakeStoreRemoteDataSource
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
        fakeStoreRemoteDataSource: FakeStoreRemoteDataSource,
        satoreLocalDataSource: StoreLocalDataSource
    ): FakeStoreRepository {
        return FakeStoreRepositoryImpl(
            fakeStoreRemoteDataSource, satoreLocalDataSource
        )
    }
}