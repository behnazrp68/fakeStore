package com.rajabi.fakestoreapplication.presentation.compose.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rajabi.divarapplication.data.util.Resource
import com.rajabi.fakestoreapplication.R
import com.rajabi.fakestoreapplication.data.model.APIResponse
import com.rajabi.fakestoreapplication.data.model.ProductItem

@Composable
fun ProductListView(
    productList: State<Resource<APIResponse>?>?,
    onNavigateDetailScreen: (ProductItem) -> Unit,
    searchList: State<List<ProductItem>?>?
    ) {


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {
        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ) {
            if(productList!=null){

                productList?.value?.data?.size?.let {
                    items(it) {
                        ShowPostRow(product = productList.value!!.data?.get(it),
                            modifier = Modifier.clickable {

                                onNavigateDetailScreen(productList.value!!.data?.get(it)!!)
                            })
                    }
                }
                when (productList?.value) { //FIRST LOAD
                    is Resource.Error -> {
                        items(
                            1,

                            ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceAround,
                            ) {


                                Text("Connection glitch")


                            }
                        }
                    }

                    is Resource.Loading -> { // Loading UI
                        items(
                            1,

                            ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceAround,
                            ) {
                                Image(
                                    painterResource(id = R.drawable.baseline_store_24),
                                    contentDescription = "",
                                    Modifier
                                        .size(60.dp)
                                        .padding(10.dp)
                                        .fillMaxWidth(),
                                    Alignment.Center,

                                    )

                                CircularProgressIndicator(
                                    color = Color.Cyan,
                                )
                            }
                        }
                    }

                    else -> {
                    }
                }

            }else if(searchList!=null){

                searchList?.value?.size?.let {
                    items(it) {
                        ShowPostRow(product = searchList.value?.get(it),
                            modifier = Modifier.clickable {
                                onNavigateDetailScreen(searchList.value?.get(it)!!)
                            })
                    }
                }

            }



        }
    }
}