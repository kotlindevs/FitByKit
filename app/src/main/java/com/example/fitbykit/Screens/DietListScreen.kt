package com.example.fitbykit.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.fitbykit.R
import com.example.fitbykit.ViewModels.DietListViewModel

@Composable
fun DietListScreen(navController: NavController, dietListViewModel: DietListViewModel = viewModel()) {

    val dietGroup = dietListViewModel.dietGroups
    val showDialog = remember { mutableStateOf(false) } // Dialog visibility state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val customFontRegular = FontFamily(
            Font(R.font.regular, FontWeight.Normal)
        )

        val customFontBold = FontFamily(
            Font(R.font.bold, FontWeight.Normal)
        )

        Text(
            text = "Day Wise Diet Plans",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.tertiary,
            fontFamily = customFontBold,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding(),
                bottom = 2.dp
            )
        )

        Text(
            text = "Remember to take everyday minimum 1.5x or maximum 2x protein of your body weight to see fast gains example if your body weight is 50kg.\n \n ~ 50 x 1.5 = 75gm (minimum) \n ~ 50 x 2.0 = 100gm (maximum)",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            fontFamily = customFontRegular,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 8.dp),
        ) {
            items(dietGroup) { (dietGroup, dietPurpose) ->
                DietGroupCard(
                    dietGroup = dietGroup,
                    dietPurpose = dietPurpose,
                    onClick = {
                        showDialog.value = true // Show dialog on card click
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }

    if (showDialog.value) {
        DevelopmentDialog(
            onDismiss = { showDialog.value = false } // Hide dialog when dismissed
        )
    }
}

@Composable
fun DietGroupCard(dietGroup: String, dietPurpose: String, onClick: () -> Unit) {
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
            val customFontBold = FontFamily(
                Font(R.font.bold, FontWeight.Normal)
            )
            val customFontRegular = FontFamily(
                Font(R.font.regular, FontWeight.Normal)
            )
            Text(
                text = dietGroup,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.Bold,
                fontFamily = customFontBold,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = dietPurpose,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                fontFamily = customFontRegular,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun DevelopmentDialog(onDismiss: () -> Unit) {

    val customFontBold = FontFamily(
        Font(R.font.bold,FontWeight.Normal)
    )

    val customFontNormal = FontFamily(
        Font(R.font.regular,FontWeight.Normal)
    )

    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = "Under Development",
                style = MaterialTheme.typography.titleLarge ,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = customFontBold
            )
        },
        text = {
            Text(
                text = "This feature is currently under development. Please check back later.",
                style = MaterialTheme.typography.titleSmall ,
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
