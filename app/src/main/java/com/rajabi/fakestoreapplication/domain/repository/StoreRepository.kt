package com.rajabi.fakestoreapplication.domain.repository

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.model.ProductItem

interface StoreRepository {
    suspend fun getAllProducts(): Resource<APIResponse>
    suspend fun getProductById (id:Int):ProductItem

    suspend fun saveProduct(product:ProductItem)


}
