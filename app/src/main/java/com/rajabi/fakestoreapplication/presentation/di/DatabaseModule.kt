package com.rajabi.fakestoreapplication.presentation.di

import android.app.Application
import androidx.room.Room
import com.rajabi.fakestoreapplication.data.db.ProductDao
import com.rajabi.fakestoreapplication.data.db.ProductDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesProductDatabase(app: Application): ProductDatabase {
        return Room.databaseBuilder(
            app, ProductDatabase::class.java,
            "productclient"
        ).build()
    }

    @Singleton
    @Provides
    fun providesProductDao(productDatabase: ProductDatabase): ProductDao {
        return productDatabase.productDao()
    }



}