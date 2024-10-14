package com.example.fitbykit

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fitbykit.Screens.HomeScreen
import com.example.fitbykit.Screens.WorkoutDetailScreen
import com.example.fitbykit.Screens.WorkoutListScreen
import com.example.fitbykit.Screens.DietListScreen



@Composable
fun NavGraph(startDestination: String = "home"){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("home") { HomeScreen(navController) }

        //workout
        composable("workoutList") { WorkoutListScreen(navController) }
        composable(
            "workoutDetail/{workout}",
            arguments = listOf(navArgument("workout") { type = NavType.StringType })
        ) { backStackEntry ->
            WorkoutDetailScreen(backStackEntry.arguments?.getString("workout") ?: "")
        }

        //diet
        composable("dietList") {DietListScreen(navController)}

    }
}