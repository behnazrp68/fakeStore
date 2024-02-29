package com.rajabi.fakestoreapplication.data.repository

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.repository.StoreRepository
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreRemoteDataSource
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreLocalDataSource
import retrofit2.Response

class StoreRepositoryImpl
    (
    private val storeRemoteDataSource: StoreRemoteDataSource,
    private val storeLocalDataSource: StoreLocalDataSource

) : StoreRepository {
    override suspend fun getAllProducts():
            Resource<APIResponse> {
        return responseToResource(storeRemoteDataSource.getProducts())
    }

    override suspend fun getProductById(id: Int): ProductItem =
        storeLocalDataSource.getProductFromDB(id)

    override suspend fun saveProduct(product: ProductItem)  =
        storeLocalDataSource.saveProductToDB(product)

    private fun responseToResource(
        response: Response<APIResponse>
    ):
            Resource<APIResponse> {
        if (response.isSuccessful) {
            val newer: APIResponse = APIResponse()
            val sortedList = response.body()?.sortedBy {
                it.price
            }?.toCollection(newer!!)
            sortedList?.let { result ->
                return Resource.Success(result)
            }

        }
        return Resource.Error(response.message())
    }

}
