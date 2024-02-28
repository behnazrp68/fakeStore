package com.rajabi.fakestoreapplication.presentation.compose.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rajabi.fakestoreapplication.R

@Composable
fun ProductImage(imageUrl: String?, modifier: Modifier? = Modifier) {

    if (imageUrl.isNullOrEmpty())
        Image(
            painter = painterResource(id = R.drawable.baseline_no_photography_24),
            contentDescription = "",
            alignment = Alignment.CenterStart,
            contentScale = ContentScale.FillBounds,
            modifier = modifier!!
                .clip(RoundedCornerShape(12.dp))
                .size(118.dp),
        )
    else
        Image(
            painter = rememberAsyncImagePainter(
                imageUrl
            ),
            contentDescription = "",
            alignment = Alignment.CenterStart,
            contentScale = ContentScale.FillBounds,
            modifier = modifier!!
                .clip(RoundedCornerShape(12.dp))
                .size(118.dp),
        )

}
