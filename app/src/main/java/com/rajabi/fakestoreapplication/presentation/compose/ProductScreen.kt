package com.rajabi.fakestoreapplication.presentation.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rajabi.fakestoreapplication.presentation.viewmodel.FakeStoreViewModel
import com.rajabi.fakestoreapplication.presentation.viewmodel.FakeStoreViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(onNavigateToAdvertisingScreen: (Int) -> Unit,
                  factory: FakeStoreViewModelFactory,
                  modifier: Modifier = Modifier,
                  fakeStoreViewModel: FakeStoreViewModel = viewModel(factory = factory)
) {
    LaunchedEffect(key1 = true) {
        fakeStoreViewModel.getProducts()

    }

    val productList = fakeStoreViewModel.products.observeAsState()
    Column (horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxWidth()){

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {


            productList.apply {
                var products =
                    this.value?.data

                products?.let {product ->
                    product?.size?.let { size ->
                        items(size) { item ->
                            ProductItem(
                                product.get(item),
                                modifier = Modifier.clickable {

                                })

                        }
                    }
                }
            }
        }
    }}