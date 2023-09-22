package com.example.maryanneapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maryanneapplication.ui.theme.pages.home.HomeScreen
import com.example.maryanneapplication.ui.theme.pages.login.LoginScreen
import com.example.maryanneapplication.ui.theme.pages.product.AddProductsScreen
import com.example.maryanneapplication.ui.theme.pages.product.TrainingScreen
import com.example.maryanneapplication.ui.theme.pages.product.UpdateProducts
import com.example.maryanneapplication.ui.theme.pages.product.ViewProductsScreen
import com.example.maryanneapplication.ui.theme.pages.product.UploadProduct
import com.example.maryanneapplication.ui.theme.pages.signup.SignupScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController :NavHostController = rememberNavController(),
    startDestination:String = ROUTE_LOGIN
) {
    NavHost(navController= navController,
        modifier = modifier,startDestination = startDestination){

        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_SIGNUP){
            SignupScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_TRAINING){
            TrainingScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCTS){
            ViewProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCTS+"/{id}"){passedData->
            UpdateProducts(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_UPLOAD_PRODUCTS){
            UploadProduct(navController)
        }
        composable(ROUTE_ADD_PRODUCTS){
            AddProductsScreen(navController)
        }

    }


}