package com.example.maryanneapplication.ui.theme.pages.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.maryanneapplication.ui.theme.MaryanneApplicationTheme


@Composable
fun TrainingScreen(rememberNavController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            var context = LocalContext.current
            Text(
                text = "Training services",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Red,
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        Icon(imageVector = Icons.Default.Search,
            contentDescription = "Search" ,
            tint = Color.Blue,

        )
        Text(text = "Services being offered;bee farming, crop farming and livestock keeping",
            fontSize = 10.sp,
            color = Color.Green,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Light,
            textDecoration = TextDecoration.None
        )

    }
    






}

@Preview
@Composable
fun TrainingScreenPreview() {
    MaryanneApplicationTheme {
        TrainingScreen(
            rememberNavController()
        )
    }

}