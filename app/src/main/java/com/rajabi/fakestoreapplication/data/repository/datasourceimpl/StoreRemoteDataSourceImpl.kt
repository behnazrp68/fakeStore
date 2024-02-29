package com.rajabi.fakestoreapplication.data.repository.datasourceimpl

import com.rajabi.fakestoreapplication.data.api.StoreAPIServices
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreRemoteDataSource
import retrofit2.Response

class StoreRemoteDataSourceImpl
    (private val storeAPIServices: StoreAPIServices) : StoreRemoteDataSource {
    override suspend fun getProducts(): Response<APIResponse> {
        return storeAPIServices.getAllProducts()
    }
}