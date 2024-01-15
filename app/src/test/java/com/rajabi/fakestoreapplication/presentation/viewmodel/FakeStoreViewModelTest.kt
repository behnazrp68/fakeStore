package com.rajabi.fakestoreapplication.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.media.AudioManager
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.anushka.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.repository.FakeProductRepository
import com.rajabi.fakestoreapplication.domain.usecase.GetAllProductsUsecase
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.shadows.ShadowContextImpl


@RunWith(RobolectricTestRunner::class)
//@RunWith(JUnit4::class)
class FakeStoreViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var fakeStoreViewModel: FakeStoreViewModel
    var products: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    @Before
    fun setup() {
        val fakeProductRepository = FakeProductRepository()
        val getAllProductsUsecase = GetAllProductsUsecase(fakeProductRepository)
        val app = getApplicationContext<Application>()

        fakeStoreViewModel = FakeStoreViewModel(app, getAllProductsUsecase)
        runBlockingTest {
            products.value = getAllProductsUsecase.execute()
        }
    }



    @Test
    fun returnErrorState() {
        fakeStoreViewModel.getProducts()
        val currentList = fakeStoreViewModel.products.getOrAwaitValue { }
        assertThat(currentList.message).isNotNull()
    }



    @Test
    fun returnSuccessState() {
        fakeStoreViewModel.getProducts()
        val currentList = fakeStoreViewModel.products.getOrAwaitValue { }
        assertThat(currentList.data).isNotNull()
    }


}