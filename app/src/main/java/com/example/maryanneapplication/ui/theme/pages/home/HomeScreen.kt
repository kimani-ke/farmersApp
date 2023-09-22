package com.example.maryanneapplication.ui.theme.pages.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.maryanneapplication.data.AuthRepository
import com.example.maryanneapplication.data.ProductRepository
import com.example.maryanneapplication.models.Upload
import com.example.maryanneapplication.navigation.ROUTE_ADD_PRODUCTS
import com.example.maryanneapplication.navigation.ROUTE_LOGIN
import com.example.maryanneapplication.navigation.ROUTE_SIGNUP
import com.example.maryanneapplication.navigation.ROUTE_TRAINING
import com.example.maryanneapplication.navigation.ROUTE_UPDATE_PRODUCTS
import com.example.maryanneapplication.navigation.ROUTE_UPLOAD_PRODUCTS
import com.example.maryanneapplication.navigation.ROUTE_VIEW_PRODUCTS
import com.example.maryanneapplication.navigation.ROUTE_UPLOAD_PRODUCTS
import com.example.maryanneapplication.ui.theme.MaryanneApplicationTheme
import com.example.maryanneapplication.ui.theme.pages.product.UploadItem

@Composable
fun HomeScreen(navController:NavHostController) {
    var context = LocalContext.current
    var productRepository = ProductRepository(navController, context)
    var authRepository = AuthRepository(navController, context)


    val emptyUploadState = remember { mutableStateOf(Upload("","","","","","")) }
    var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

    var uploads = productRepository.viewUploads(emptyUploadState, emptyUploadsListState)
    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Welcome to HomeScreen",
            color = Color.Magenta,
            fontFamily = FontFamily.Serif,
            fontSize = 24.sp,
        )



            Row(modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())) {
                Button(onClick = {
                    navController.navigate(ROUTE_ADD_PRODUCTS)
                }) {
                    Text(text = "Add Products ")
                }
                Spacer(modifier = Modifier.width(30.dp))

                Button(onClick = {
                    navController.navigate(ROUTE_TRAINING)
                }) {
                    Text(text = " Training")

                }
                Spacer(modifier = Modifier.width(30.dp))

                Button(onClick = {
                    navController.navigate(ROUTE_VIEW_PRODUCTS)
                }) {
                    Text(text = "view  products")

                }
                Spacer(modifier = Modifier.width(30.dp))

                Button(onClick = {
                    navController.navigate(ROUTE_ADD_PRODUCTS)
                }) {
                    Text(text = "Training")

                }
                Spacer(modifier = Modifier.width(30.dp))

                Button(onClick = {
                    navController.navigate(ROUTE_UPDATE_PRODUCTS)
                }) {
                    Text(text = "Update Products")
                }
                Spacer(modifier = Modifier.width(30.dp))

                Button(onClick = {
                    authRepository.logout()
                }) {
                    Text(text = "Logout")
                }
            }




        Column(
            modifier = Modifier
                .height(400.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "On our quality shelves today!",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(uploads){
                    FarmItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        desc = it.description,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }
        }

        }

}

@Composable
fun FarmItem(name:String, quantity:String, price:String, imageUrl:String,desc:String, id:String,
               navController: NavHostController, productRepository: ProductRepository
) {

    Column(modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp)) {
        Text(text = name)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(300.dp)
        )
        Text(text = quantity)
        Text(text = price)
        Text(text = desc)
    }
}
@Preview
@Composable
fun HomeScreenPreview() {
    MaryanneApplicationTheme {
        HomeScreen(rememberNavController())
    }

}