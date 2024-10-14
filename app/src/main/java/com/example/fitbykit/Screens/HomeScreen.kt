package com.example.fitbykit.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.fitbykit.R

@Composable
fun HomeScreen(navController: NavController) {
    val customNormal = FontFamily(
        Font(R.font.regular, FontWeight.Normal)
    )
    val customBold = FontFamily(
        Font(R.font.bold, FontWeight.Bold)
    )
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.fitbykit))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            @Suppress("DEPRECATION")
            LottieAnimation(
                composition,
                progress,
                modifier = Modifier.size(256.dp),
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Welcome to Fit By Kit",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = customBold,
                fontSize = 24.sp,
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate("workoutList") },
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .padding(horizontal = 8.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(4.dp)
            ) {
                Text(
                    text = "Show Workouts",
                    fontFamily = customNormal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }

            Button(
                onClick = { navController.navigate("dietList") },
                elevation = ButtonDefaults.elevatedButtonElevation(4.dp)
            ) {
                Text(
                    text = "View Diet Plans",
                    fontFamily = customNormal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
        }
    }
}
