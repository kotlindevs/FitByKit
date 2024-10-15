package com.example.fitbykit

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.fitbykit.Notifications.NotificationRepository
import com.example.fitbykit.Notifications.NotificationViewModel
import com.example.fitbykit.Notifications.NotificationViewModelFactory
import com.example.fitbykit.ui.theme.FitByKitTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val NOTIFICATION_PERMISSION_REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        createNotificationChannel()

        // Check and request notification permission for Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // Request the notification permission
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                    NOTIFICATION_PERMISSION_REQUEST_CODE
                )
            } else {
                // Permission already granted, proceed with setting notifications
                setupNotificationViewModel()
            }
        } else {
            // For Android versions below 13, no need for explicit permission
            setupNotificationViewModel()
        }

        setContent {
            FitByKitTheme {
                NavGraph()
            }
        }
    }

    private fun setupNotificationViewModel() {
        val notificationRepository = NotificationRepository()

        // Create the ViewModelFactory
        val factory = NotificationViewModelFactory(notificationRepository)

        // Get the ViewModel instance using the factory
        val notificationViewModel = ViewModelProvider(this, factory)
            .get(NotificationViewModel::class.java)

        // Set the notifications
        notificationViewModel.scheduleDailyNotifications(this)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "fitbykitChannel"
            val channelName = "FitByKit Notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                description = "Channel for daily reminders"
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    // Handle the result of the permission request
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == NOTIFICATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, set up the notifications
                setupNotificationViewModel()
            } else {
                // Permission denied, you might want to show a message to the user
            }
        }
    }
}
