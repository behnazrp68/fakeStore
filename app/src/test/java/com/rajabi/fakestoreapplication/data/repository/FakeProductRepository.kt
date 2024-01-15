package com.rajabi.fakestoreapplication.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.model.APIResponseItem
import com.rajabi.fakestoreapplication.data.model.Rating
import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository
import org.junit.Rule
import retrofit2.Response

class FakeProductRepository : FakeStoreRepository {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    var products: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    init {
        val s = APIResponseItem(
            "clothing", "mens clothing casual",
            1, "", 2.5, Rating(1, 2.5), "casual "
        )
        products.value=Resource.Success(APIResponse())
        (products.value as Resource.Success<APIResponse>).data?.add(s)
    }

    override suspend fun getAllProducts(): Resource<APIResponse> {
        return products.value!!
    }

}