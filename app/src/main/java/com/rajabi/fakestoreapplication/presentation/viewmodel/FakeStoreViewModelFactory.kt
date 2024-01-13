package com.rajabi.fakestoreapplication.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase

class FakeStoreViewModelFactory
    (
    private val app: Application,
    private val getAllProductsUsecase: GetAllProductsUsecase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FakeStoreViewModel(
            app,
            getAllProductsUsecase
        ) as T
    }
}