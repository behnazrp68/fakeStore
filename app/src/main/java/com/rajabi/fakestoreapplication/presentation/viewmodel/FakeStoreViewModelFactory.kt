package com.rajabi.fakestoreapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import com.rajabi.fakestoreapplication.domain.usecase.GetProductByIDUsecase
import com.rajabi.fakestoreapplication.domain.usecase.SaveProductUsecase

class FakeStoreViewModelFactory
    (
    private val app: Application,
    private val getAllProductsUsecase: GetAllProductsUsecase,
    private val saveProductUsecase: SaveProductUsecase,
    private val getProductByIDUsecase: GetProductByIDUsecase

) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FakeStoreViewModel(
            app,
            getAllProductsUsecase,
            saveProductUsecase,getProductByIDUsecase
        ) as T
    }
}