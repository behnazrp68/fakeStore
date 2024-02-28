package com.rajabi.fakestoreapplication.presentation.compose.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajabi.fakestoreapplication.data.model.ProductItem

@Composable
fun ShowPostRow(
    modifier: Modifier,
    product: ProductItem?
) {
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
            Column(modifier = Modifier.padding(12.dp)) {
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
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                lineHeight = 20.sp,
                            )
                        }



                        Spacer(modifier = Modifier.height(16.dp))



                        product?.price?.let {
                            Text(
                                text = " Price: "+ it.toInt().toString() ,
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Normal,
                                lineHeight = 20.sp,
                            )
                        }
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


                }

            }
        }

}