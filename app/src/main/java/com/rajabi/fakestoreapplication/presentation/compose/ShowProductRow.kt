package com.rajabi.fakestoreapplication.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.rajabi.fakestoreapplication.data.model.APIResponseItem

@Composable
fun ShowPostRow(
    modifier: Modifier,
    value: APIResponseItem?
) {
    Card(
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),

        shape = MaterialTheme.shapes.medium,

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = rememberAsyncImagePainter(value?.image),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Column(
                Modifier.padding(8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                value?.title?.let {
                    Text(
                        text = it,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        style = MaterialTheme.typography.headlineSmall,

                        textAlign = TextAlign.Start
                    )
                }
                value?.price.let {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        text = "Price: " + it,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.End
                    )
                }
                value?.description.let {
                    Text(
                        modifier = Modifier.padding(10.dp),

                        text = it.toString(),
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Justify
                    )
                }
                value?.category.let {
                    Text(
                        modifier = Modifier.padding(10.dp),

                        text = "Category: " + it,
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Start
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ) {


                    value?.rating.let {
                        Text(
                            text = "Rate: " + it?.rate,
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.End
                        )

                    }
                    value?.rating.let {
                        Text(
                            text = "Count: " + it?.count,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.End
                        )
                    }
                }
            }
        }
    }
}