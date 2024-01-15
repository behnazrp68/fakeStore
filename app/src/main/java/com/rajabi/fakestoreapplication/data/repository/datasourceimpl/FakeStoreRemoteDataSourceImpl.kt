package com.rajabi.fakestoreapplication.data.repository.datasourceimpl

import com.rajabi.fakestoreapplication.data.api.FakeStoreAPIServices
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.repository.datasource.FakeStoreRemoteDataSource
import retrofit2.Response

class FakeStoreRemoteDataSourceImpl
    (private val fakeStoreAPIServices: FakeStoreAPIServices) : FakeStoreRemoteDataSource {
    override suspend fun getProducts(): Response<APIResponse> {
        return fakeStoreAPIServices.getAllProducts()
    }
}