package com.rajabi.fakestoreapplication.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.repository.StoreRepository
import org.junit.Rule

class ProductRepository : StoreRepository {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    var products: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    init {
        val s = ProductItem(
            "clothing", "mens clothing casual",
            1, "", 2.5,  "casual ",true
        )
        products.value=Resource.Success(APIResponse())
        (products.value as Resource.Success<APIResponse>).data?.add(s)
    }

    override suspend fun getAllProducts(): Resource<APIResponse> {
        return products.value!!
    }

    override suspend fun getProductById(id: Int): ProductItem {
        TODO("Not yet implemented")
    }

    override suspend fun saveProduct(product: ProductItem) {
        TODO("Not yet implemented")
    }



}