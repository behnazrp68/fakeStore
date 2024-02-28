package com.rajabi.fakestoreapplication.domain.usecase

import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository

open class UpdateProductUsecase(private val fakeStoreRepository: FakeStoreRepository) {
    suspend fun execute(id: Int, isBookmark: Boolean) {

         fakeStoreRepository.updateProduct(id, isBookmark)
    }

}