package com.example.fitbykit.Screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fitbykit.R
import com.example.fitbykit.Repository.WorkoutRepository
import com.example.fitbykit.ViewModels.WorkoutDetailViewModel
import com.example.fitbykit.ViewModels.WorkoutDetailViewModelFactory
import kotlinx.coroutines.launch

@Composable
fun WorkoutDetailScreen(workout: String) {
    // Create an instance of the repository
    val workoutRepository = remember { WorkoutRepository() }
    // Create the ViewModel
    val viewModel: WorkoutDetailViewModel = viewModel(factory = WorkoutDetailViewModelFactory(workoutRepository))

    // Get workout details
    val workoutDetails by viewModel.workoutDetails.collectAsState()

    // Initialize the ViewModel to load workout details
    val scope = rememberCoroutineScope()
    remember { scope.launch { viewModel.getWorkoutDetails(workout) } }

    val context = LocalContext.current

    // Main column layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Custom font for workout title
        val customFontRegular = FontFamily(Font(R.font.regular, FontWeight.Bold))
        Text(
            text = workout,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp),
            fontFamily = customFontRegular,
        )

        // Scrollable column for workout details
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            workoutDetails.forEach { detail ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFB3B3), contentColor = Color.Black),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            // Open YouTube link
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(detail.second))
                            context.startActivity(intent)
                        }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        // Custom font for exercise title
                        val customFontFamily = FontFamily(Font(R.font.bold, FontWeight.Normal))
                        Text(
                            text = detail.first,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 18.sp,
                                fontFamily = customFontFamily,
                                color = Color.Black
                            )
                        )
                    }
                }
            }
        }
    }
}
