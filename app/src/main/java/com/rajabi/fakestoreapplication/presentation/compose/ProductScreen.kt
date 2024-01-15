package com.rajabi.fakestoreapplication.presentation.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
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
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
    onNavigateToAdvertisingScreen: (Int) -> Unit,
    factory: FakeStoreViewModelFactory,
    modifier: Modifier = Modifier,
    fakeStoreViewModel: FakeStoreViewModel = viewModel(factory = factory)
) {
    LaunchedEffect(key1 = true) {
        fakeStoreViewModel.getProducts()
//        fakeStoreViewModel.getSearchedProducts()

    }

    val productList = fakeStoreViewModel.products.observeAsState()
    //Collecting states from ViewModel
    val searchText by fakeStoreViewModel.searchText.collectAsState()
    val isSearching by fakeStoreViewModel.isSearching.collectAsState()
    val searchList = fakeStoreViewModel.searchProducts.observeAsState()
    Column(
        horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()
    ) {
        SearchBar(
            query = searchText,//text showed on SearchBar
            onQueryChange = fakeStoreViewModel::onSearchTextChange, //update the value of searchText
            onSearch = fakeStoreViewModel::onSearchTextChange, //the callback to be invoked when the input service triggers the ImeAction.Search action
            active = isSearching, //whether the user is searching or not
            onActiveChange = { fakeStoreViewModel.onToogleSearch() }, //the callback to be invoked when this search bar's active state is changed
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(16.dp)
            ) {

                searchList.apply {

                    searchList?.value?.size?.let { size ->
                        items(size) { item ->
                            ProductItem(searchList.value!!.get(item), modifier = Modifier)

                        }
                    }


                }


            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {


            productList.apply {
                var products =
                    this.value?.data

                products?.let { product ->
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
    }
}
