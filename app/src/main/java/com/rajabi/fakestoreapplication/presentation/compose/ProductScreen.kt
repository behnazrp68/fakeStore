package com.rajabi.fakestoreapplication.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.presentation.viewmodel.FakeStoreViewModel
import com.rajabi.fakestoreapplication.presentation.viewmodel.FakeStoreViewModelFactory
import com.rajabi.fakestoreapplication.presentation.compose.widgets.ProductListView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(
    onNavigateDetailScreen: (ProductItem) -> Unit,
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
            ProductListView(
                searchList = searchList,
                onNavigateDetailScreen = onNavigateDetailScreen,
                productList = null
            )

        }

            ProductListView(
                productList = productList,
                onNavigateDetailScreen = onNavigateDetailScreen,
                searchList = null
            )
        }
    }

