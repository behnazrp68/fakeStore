package com.rajabi.fakestoreapplication.presentation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.rajabi.fakestoreapplication.data.model.ProductItem
import com.rajabi.fakestoreapplication.data.model.ProductArgType
import com.rajabi.fakestoreapplication.presentation.viewmodel.FakeStoreViewModelFactory

@Composable
fun AppNavHost(
    factory: FakeStoreViewModelFactory,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "product_screen"
    ) {
        composable(route = "product_screen") {
            ProductScreen(
                onNavigateDetailScreen = {
                    navController.navigate("detail_screen/$it")
                },
                factory = factory
            )
        }

        composable(route = "detail_screen/{product}",
            arguments = listOf(navArgument("product") {
                type = ProductArgType()
            })
        )
        {

                navBackStackEntry ->
            val product = navBackStackEntry.arguments?.getString("product")?.let {
                Gson().fromJson(it, ProductItem::class.java)
            }
            if (product != null) {
                DetailScreen(product,

                    factory = factory)
            }
        }

    }
}