package com.rajabi.fakestoreapplication.domain.usecase

import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository

open class SaveProductUsecase(private val fakeStoreRepository: FakeStoreRepository) {
    suspend fun execute(productItem: ProductItem) {

        fakeStoreRepository.saveProduct(productItem)
    }

}