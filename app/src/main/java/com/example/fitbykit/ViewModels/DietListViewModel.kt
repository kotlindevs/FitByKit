package com.example.fitbykit.ViewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel

class DietListViewModel : ViewModel() {
    private val _dietGroup = mutableStateListOf(

        "Monday" to "Meal Plan 1",

        "Tuesday" to "Meal Plan 2",

        "Wednesday" to "Meal Plan 3",

        "Thursday" to "Meal Plan 4",

        "Friday" to "Meal Plan 5",

        "Saturday" to "Meal Plan 6",

        "Sunday" to "Meal Plan 7",

    )

    val dietGroups : SnapshotStateList<Pair<String,String>>
        get() = _dietGroup
}