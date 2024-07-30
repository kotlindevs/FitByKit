package com.example.fitbykit.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fitbykit.R

val Regular = FontFamily(Font(R.font.regular, FontWeight.Normal))
val Bold = FontFamily(Font(R.font.bold, FontWeight.Bold))

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Bold,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    titleMedium = TextStyle(
        fontFamily = Regular,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
    // Add other text styles as needed
)
