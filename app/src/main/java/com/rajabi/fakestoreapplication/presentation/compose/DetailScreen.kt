package com.rajabi.fakestoreapplication.presentation.compose

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.rajabi.fakestoreapplication.R
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.presentation.compose.widgets.ProductImage
import com.rajabi.fakestoreapplication.presentation.viewmodel.FakeStoreViewModel
import com.rajabi.fakestoreapplication.presentation.viewmodel.FakeStoreViewModelFactory

@Composable
fun DetailScreen(
    product: ProductItem,
    modifier: Modifier = Modifier.fillMaxSize(),
    context: Context = LocalContext.current,
    factory: FakeStoreViewModelFactory,
    fakeStoreViewModel: FakeStoreViewModel = viewModel(factory = factory)

) {
    fakeStoreViewModel.getProductById(product.id)
    val productByID = fakeStoreViewModel.product.observeAsState()

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

        Card(
            shape = RoundedCornerShape(2),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp)
                .clip(RoundedCornerShape(12))
                .border(1.dp, Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                var model by remember { mutableStateOf(R.drawable.baseline_star_border_24) }
                if (productByID.value?.isBookmark == true) {
                    model = R.drawable.baseline_star_24
                } else {
                    model = R.drawable.baseline_star_border_24
                }
                AsyncImage(

                    model = model,
                    contentDescription = "",
                    modifier = Modifier
                        .clickable(onClick = {
                            if (productByID != null && productByID.value?.isBookmark == true) {
                                model = R.drawable.baseline_star_border_24
                                fakeStoreViewModel.updateProduct(product.id, false)

                            } else if (productByID != null && productByID.value?.isBookmark == false) {
                                model = R.drawable.baseline_star_24
                                fakeStoreViewModel.updateProduct(product.id, false)

                            } else {
                                model = R.drawable.baseline_star_24
                                product.isBookmark = true
                                fakeStoreViewModel.saveProduct(product)
                            }

                        })
                        .align(Alignment.End)
                        .size(35.dp),

                    )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    ProductImage(imageUrl = product?.image)
                    Spacer(modifier = Modifier.width(12.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {

                        product?.title?.let {
                            Text(
                                text = it,
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.ExtraBold,
                                lineHeight = 20.sp,
                            )
                        }

                        Spacer(modifier = Modifier.height(12.dp))




                        Spacer(modifier = Modifier.height(12.dp))

                        if (!product?.category.isNullOrEmpty())
                            product?.category?.let {
                                Text(
                                    text = it,
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    lineHeight = 20.sp,
                                )


                            }

                    }
                }
                Column {


                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {


                        product?.price?.let {
                            Text(
                                text = "Price : " + it.toInt().toString() + "$ ",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                lineHeight = 20.sp,
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))

                    }
                    Spacer(modifier = Modifier.height(12.dp))


                    product?.description?.let {
                        Text(
                            text = "details : ",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 20.sp,
                        )
                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = it,
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            lineHeight = 20.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))

                }


            }
        }
    }
}
