package com.rajabi.fakestoreapplication.domain.usecase

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.domain.repository.StoreRepository

open class GetAllProductsUsecase(private val storeRepository: StoreRepository) {
    suspend fun execute(): Resource<APIResponse> {

        return storeRepository.getAllProducts()
    }

}