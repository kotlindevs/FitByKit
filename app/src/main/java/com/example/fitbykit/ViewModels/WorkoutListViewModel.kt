package com.example.fitbykit.ViewModels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class WorkoutListViewModel : ViewModel() {
    // LiveData or State to hold muscle groups
    private val _muscleGroups = mutableStateListOf(
        "Chest" to "Primary muscles: Pectoralis major and minor. Function: Pushes the arm in front of the body.",
        "Shoulders" to "Primary muscles: Deltoids. Function: Raises the arm away from the body and rotates it.",
        "Triceps" to "Primary muscles: Triceps brachii. Function: Straightens the arm at the elbow.",
        "Back" to "Primary muscles: Latissimus dorsi, rhomboids, and trapezius. Function: Pulls the arm down and towards the body.",
        "Biceps" to "Primary muscles: Biceps brachii. Function: Bends the arm at the elbow.",
        "Legs" to "Primary muscles: Quadriceps, hamstrings, calves. Function: Supports body weight and allows movement."
    )

    val muscleGroups: SnapshotStateList<Pair<String, String>>
        get() = _muscleGroups
}
