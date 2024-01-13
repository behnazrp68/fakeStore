package com.rajabi.fakestoreapplication.repository.datasource

import com.rajabi.fakestoreapplication.data.model.APIResponse

import retrofit2.Response

interface FakeStoreRemoteDataSource {

    suspend fun getProducts(): Response<APIResponse>
}