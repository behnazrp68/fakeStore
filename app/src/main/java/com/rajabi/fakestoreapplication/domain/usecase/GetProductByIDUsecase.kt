package com.rajabi.fakestoreapplication.domain.usecase

import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.repository.FakeStoreRepository

open class GetProductByIDUsecase(private val fakeStoreRepository: FakeStoreRepository){
suspend fun execute(id:Int): ProductItem {

    return fakeStoreRepository.getProductById(id)
}

}