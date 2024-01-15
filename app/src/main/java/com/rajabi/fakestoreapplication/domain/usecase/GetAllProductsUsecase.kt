package com.rajabi.fakestoreapplication.domain.usecase

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository

open class GetAllProductsUsecase(private val fakeStoreRepository: FakeStoreRepository) {
    suspend fun execute(): Resource<APIResponse> {
        return fakeStoreRepository.getAllProducts()
    }

}