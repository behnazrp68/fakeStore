package com.rajabi.fakestoreapplication.data.repository.datasource

import com.rajabi.fakestoreapplication.data.model.APIResponse

import retrofit2.Response

interface StoreRemoteDataSource {

    suspend fun getProducts(): Response<APIResponse>
}