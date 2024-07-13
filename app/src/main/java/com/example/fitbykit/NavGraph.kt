package com.example.fitbykit

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun NavGraph(startDestination: String = "home"){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("home") { HomeScreen(navController) }
        composable("workoutList") { WorkoutListScreen(navController) }
        composable(
            "workoutDetail/{workout}",
            arguments = listOf(navArgument("workout") { type = NavType.StringType })
        ) { backStackEntry ->
            WorkoutDetailScreen(backStackEntry.arguments?.getString("workout") ?: "")
        }
    }
}