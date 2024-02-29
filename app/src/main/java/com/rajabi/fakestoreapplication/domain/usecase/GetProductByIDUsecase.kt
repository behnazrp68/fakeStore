package com.rajabi.fakestoreapplication.domain.usecase

import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.domain.repository.StoreRepository

open class GetProductByIDUsecase(private val storeRepository: StoreRepository){
suspend fun execute(id:Int): ProductItem {

    return storeRepository.getProductById(id)
}

}