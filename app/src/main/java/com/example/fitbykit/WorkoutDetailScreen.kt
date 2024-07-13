package com.example.fitbykit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WorkoutDetailScreen(workout: String) {
    val workoutDetails = getWorkoutDetails(workout)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = workout, style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        workoutDetails.forEach { detail ->
            Text(
                text = detail,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

fun getWorkoutDetails(workout: String): List<String> {
    return when (workout) {
        "Chest" -> listOf(
            "1. Bench Press - 4 sets of 8-12 reps",
            "2. Incline Dumbbell Press - 4 sets of 8-12 reps",
            "3. Cable Flyes - 3 sets of 12-15 reps",
        )
        "Shoulders" -> listOf(
            "1. Incline Press Machine - 3 sets of 12-15 reps",
            "2. Overhead Press - 4 sets of 8-12 reps",
            "3. Lateral Raises - 4 sets of 12-15 reps",
            "4. Front Raises - 3 sets of 12-15 reps",
        )
        "Triceps" -> listOf(
            "1. Tricep Dips - 4 sets of 8-12 reps",
            "2. Tricep Pushdowns - 4 sets of 12-15 reps",
            "3. Overhead Tricep Extension - 3 sets of 12-15 reps"
        )
        "Back" -> listOf(
            "1. Lat Pull Down - 4 sets of 8-12 reps",
            "2. Seated Row Machine - 3 sets of 8-12 reps",
            "3. T-bar Row Machine - 3 sets of 8-12 reps",
            "4. Rear Delt Fly Machine - 3 sets of 8-12 reps",
            "5. Dumbbell Shrugs - 3 sets of 8-12 reps",
        )
        "Biceps" -> listOf(
            "1. Barbell Curls - 4 sets of 8-12 reps",
            "2. Hammer Curls - 4 sets of 12-15 reps",
            "3. Concentration Curls - 3 sets of 12-15 reps"
        )
        "Legs" -> listOf(
            "1. Squats - 4 sets of 8-12 reps",
            "2. Leg Press - 4 sets of 12-15 reps",
            "3. Leg Curls - 4 sets of 12-15 reps",
            "4. Leg Extensions - 4 sets of 12-15 reps",
            "5. Calf Raises - 4 sets of 15-20 reps"
        )
        else -> emptyList()
    }
}