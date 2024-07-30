package com.example.fitbykit.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitbykit.Repository.WorkoutRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WorkoutDetailViewModel(private val workoutRepository: WorkoutRepository) : ViewModel() {

    private val _workoutDetails = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val workoutDetails: StateFlow<List<Pair<String, String>>> get() = _workoutDetails

    fun getWorkoutDetails(workout: String) {
        viewModelScope.launch {
            _workoutDetails.value = workoutRepository.getWorkoutDetails(workout)
        }
    }
}
