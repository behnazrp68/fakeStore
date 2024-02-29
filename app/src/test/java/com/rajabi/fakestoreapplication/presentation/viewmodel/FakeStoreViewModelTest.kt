package com.rajabi.fakestoreapplication.presentation.viewmodel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.anushka.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.repository.ProductRepository
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import com.rajabi.fakestoreapplication.domain.usecase.GetProductByIDUsecase
import com.rajabi.fakestoreapplication.domain.usecase.SaveProductUsecase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
//@RunWith(JUnit4::class)
class FakeStoreViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var fakeStoreViewModel: FakeStoreViewModel
    var products: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    @Before
    fun setup() {
        val fakeProductRepository = ProductRepository()
        val getAllProductsUsecase = GetAllProductsUsecase(fakeProductRepository)
        val saveProductUsecase = SaveProductUsecase(fakeProductRepository)
        val getProductByIDUsecase = GetProductByIDUsecase(fakeProductRepository)

        val app = getApplicationContext<Application>()

        fakeStoreViewModel = FakeStoreViewModel(app,
            getAllProductsUsecase,
            saveProductUsecase,
            getProductByIDUsecase)
        runBlockingTest {
            products.value = getAllProductsUsecase.execute()
        }
    }



    @Test
    fun returnErrorState() {
        fakeStoreViewModel.getProducts()
        val currentList = fakeStoreViewModel.products.getOrAwaitValue{}
        assertThat(currentList.message).isNotNull()
    }


    @Test
    fun returnLoadingState() {
        fakeStoreViewModel.getProducts()
        val currentList = fakeStoreViewModel.products.getOrAwaitValue{}
        assertThat(currentList.data).isNull()
    }

    @Test
    fun returnSuccessState() {
        fakeStoreViewModel.getProducts()
        val currentList = fakeStoreViewModel.products.getOrAwaitValue { }
        assertThat(currentList.data).isNotNull()
    }


}