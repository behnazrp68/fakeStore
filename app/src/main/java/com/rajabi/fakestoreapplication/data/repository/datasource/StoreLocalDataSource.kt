package com.rajabi.fakestoreapplication.data.repository.datasource

import com.rajabi.fakestoreapplication.data.model.ProductItem

interface StoreLocalDataSource {
    suspend fun getProductFromDB(id:Int): ProductItem
    suspend fun saveProductToDB(product: ProductItem)

    suspend fun clearAll()

    suspend fun updateBookmark(id:Int,isbookmark: Boolean)}
