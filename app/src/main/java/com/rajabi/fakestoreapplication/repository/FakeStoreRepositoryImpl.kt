package com.rajabi.fakestoreapplication.repository

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository
import com.rajabi.fakestoreapplication.repository.datasource.FakeStoreRemoteDataSource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class FakeStoreRepositoryImpl
    (
    private val divarRemoteDataSource: FakeStoreRemoteDataSource
) : FakeStoreRepository {
    override suspend fun getAllProducts():
            Resource<APIResponse> {
        return responseToResource(
            divarRemoteDataSource.getProducts())
    }


    private fun responseToResource(
        response: Response<APIResponse>):
            Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }

        }
        return Resource.Error(response.message())
    }

}
