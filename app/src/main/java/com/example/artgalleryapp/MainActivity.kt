package com.example.artgalleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarGalleryApp()
        }
    }
}

data class Car(
    val imageRes: Int,
    val name: String,
    val category: String
)

@Composable
fun CarGalleryApp() {

    val cars = listOf(
        Car(R.drawable.bmw, "BMW M4 GT4", "Track Car"),
        Car(R.drawable.f1_car, "Formula 1 Car", "Professional Racing Machine"),
        Car(R.drawable.suv, "Range Rover SUV", "Premium Sport Utility Vehicle")
    )

    var currentIndex by remember { mutableIntStateOf(0) }

    val currentCar = cars[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = currentCar.imageRes),
            contentDescription = currentCar.name,
            modifier = Modifier
                .height(280.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = currentCar.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = currentCar.category,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                currentIndex =
                    if (currentIndex == 0) cars.size - 1
                    else currentIndex - 1
            }) {
                Text("Previous")
            }

            Button(onClick = {
                currentIndex =
                    if (currentIndex == cars.size - 1) 0
                    else currentIndex + 1
            }) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCarGallery() {
    CarGalleryApp()
}