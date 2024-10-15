package com.example.fitbykit.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitbykit.R
import com.example.fitbykit.ViewModels.DietListViewModel

@Composable
fun DietListScreen(navController: NavController, dietListViewModel: DietListViewModel = viewModel()) {

    val dietGroup = dietListViewModel.dietGroups
    val showDialog = remember { mutableStateOf(false) }
    val completedDietGroups = remember { mutableStateListOf<Boolean>() }

    LaunchedEffect(dietGroup) {
        if (dietGroup.isNotEmpty()) {
            completedDietGroups.clear()
            completedDietGroups.addAll(List(dietGroup.size) { false })
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val customFontRegular = FontFamily(Font(R.font.regular, FontWeight.Normal))
        val customFontBold = FontFamily(Font(R.font.bold, FontWeight.Normal))

        Text(
            text = "Day Wise Diet Plans",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.tertiary,
            fontFamily = customFontBold,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(), bottom = 8.dp)
        )

        Text(
            text = "Remember to take everyday minimum 1.5x or maximum 2x protein of your body weight to see fast gains example if your body weight is 50kg.\n \n ~ 50 x 1.5 = 75gm (minimum) \n ~ 50 x 2.0 = 100gm (maximum)",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = customFontRegular,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (dietGroup.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(dietGroup.indices.toList()) { index ->
                    DietGroupCard(
                        dietGroup = dietGroup[index].first,
                        dietPurpose = dietGroup[index].second,
                        isCompleted = completedDietGroups.getOrNull(index) ?: false,
                        onClick = {
                            completedDietGroups[index] = !completedDietGroups[index]
                        }
                    )
                }
            }
        } else {
            Text(
                text = "No diet plans available.",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontFamily = customFontRegular,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }

    if (showDialog.value) {
        DevelopmentDialog(
            onDismiss = { showDialog.value = false }
        )
    }
}

@Composable
fun DietGroupCard(dietGroup: String, dietPurpose: String, isCompleted: Boolean, onClick: () -> Unit) {
    val textDecoration = if (isCompleted) TextDecoration.LineThrough else null

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .heightIn(min = 120.dp)
        ) {
            Text(
                text = dietGroup,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary,
                textDecoration = textDecoration,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dietPurpose,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun DevelopmentDialog(onDismiss: () -> Unit) {
    val customFontBold = FontFamily(Font(R.font.bold, FontWeight.Normal))
    val customFontNormal = FontFamily(Font(R.font.regular, FontWeight.Normal))

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = "Under Development",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = customFontBold
            )
        },
        text = {
            Text(
                text = "This feature is currently under development. Please check back later.",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = customFontNormal
            )
        },
        confirmButton = {
            Button(onClick = { onDismiss() }) {
                Text(text = "OK")
            }
        }
    )
}
