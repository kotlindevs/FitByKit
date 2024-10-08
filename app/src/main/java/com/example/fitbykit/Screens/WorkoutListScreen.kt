package com.example.fitbykit.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitbykit.R
import com.example.fitbykit.ViewModels.WorkoutListViewModel

@Composable
fun WorkoutListScreen(navController: NavController, workoutListViewModel: WorkoutListViewModel = viewModel()) {

    val muscleGroups = workoutListViewModel.muscleGroups

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val customFontBold = FontFamily(
            Font(R.font.bold, FontWeight.Normal)
        )

        val customFontRegular = FontFamily(
            Font(R.font.regular, FontWeight.Normal)
        )

        Text(
            text = "Workout List",
            style = MaterialTheme.typography.headlineLarge,
            fontFamily = customFontRegular,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            items(muscleGroups) { (muscleGroup, musclePurpose) ->
                MuscleGroupCard(
                    muscleGroup = muscleGroup,
                    musclePurpose = musclePurpose,
                    onClick = {
                        navController.navigate("workoutDetail/$muscleGroup")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun MuscleGroupCard(muscleGroup: String, musclePurpose: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
      /*  colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFB3B3)
        ) */
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .heightIn(min = 120.dp)
        ) {
            val customFontBold = FontFamily(
                Font(R.font.bold, FontWeight.Normal)
            )
            val customFontRegular = FontFamily(
                Font(R.font.regular, FontWeight.Normal)
            )
            Text(
                text = muscleGroup,
                style = MaterialTheme.typography.titleLarge,
              //  color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontFamily = customFontBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = musclePurpose,
                style = MaterialTheme.typography.titleMedium,
                fontFamily = customFontRegular,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
