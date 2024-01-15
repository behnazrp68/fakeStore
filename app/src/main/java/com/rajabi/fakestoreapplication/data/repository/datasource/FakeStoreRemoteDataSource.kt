package com.rajabi.fakestoreapplication.data.repository.datasource

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse

import retrofit2.Response

interface FakeStoreRemoteDataSource {

    suspend fun getProducts(): Response<APIResponse>
}