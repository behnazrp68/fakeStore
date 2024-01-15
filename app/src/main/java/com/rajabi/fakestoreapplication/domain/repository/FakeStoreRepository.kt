package com.rajabi.fakestoreapplication.domain.repository

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import retrofit2.Response

interface FakeStoreRepository {
    suspend fun getAllProducts(): Resource<APIResponse>

}
