package com.rajabi.fakestoreapplication.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.rajabi.fakestoreapplication.data.model.APIResponseItem


@Composable
fun ProductItem(
    value: APIResponseItem?, modifier: Modifier) {
    ShowPostRow(
        modifier = modifier, value = value)
}