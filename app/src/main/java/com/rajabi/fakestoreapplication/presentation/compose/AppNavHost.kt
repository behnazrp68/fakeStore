package com.rajabi.fakestoreapplication.presentation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                onNavigateToAdvertisingScreen = {
                    navController.navigate("advertising_screen/$it")
                },
                factory = factory
            )
        }

    }
}