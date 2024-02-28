package com.rajabi.fakestoreapplication.data.repository

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository
import com.rajabi.fakestoreapplication.data.repository.datasource.FakeStoreRemoteDataSource
import com.rajabi.fakestoreapplication.data.repository.datasource.StoreLocalDataSource
import retrofit2.Response

class FakeStoreRepositoryImpl
    (
    private val storeRemoteDataSource: FakeStoreRemoteDataSource,
    private val storeLocalDataSource: StoreLocalDataSource

) : FakeStoreRepository {
    override suspend fun getAllProducts():
            Resource<APIResponse> {
        return responseToResource(storeRemoteDataSource.getProducts())
    }

    override suspend fun getProductById(id: Int): ProductItem =
        storeLocalDataSource.getProductFromDB(id)

    override suspend fun saveProduct(product: ProductItem)  =
        storeLocalDataSource.saveProductToDB(product)
    override suspend fun updateProduct(id: Int, isBookmark: Boolean) =
        storeLocalDataSource.updateBookmark(id,isBookmark)

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
