package com.rajabi.fakestoreapplication.data.repository.datasourceimpl

import com.rajabi.fakestoreapplication.data.db.ProductDao
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreLocalDataSource

class StoreLocalDataSourceImpl
    (private val productDao: ProductDao) : StoreLocalDataSource {
    override suspend fun getProductFromDB(id: Int) =
        productDao.getProducts(id)


    override suspend fun saveProductToDB(product: ProductItem) =
        productDao.saveProducts(product)

    override suspend fun clearAll() =
        productDao.deleteAllProducts()


}