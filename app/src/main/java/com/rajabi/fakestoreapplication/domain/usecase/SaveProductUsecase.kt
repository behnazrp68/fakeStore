package com.rajabi.fakestoreapplication.domain.usecase

import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.repository.StoreRepository

open class SaveProductUsecase(private val storeRepository: StoreRepository) {
    suspend fun execute(productItem: ProductItem) {

        storeRepository.saveProduct(productItem)
    }

}