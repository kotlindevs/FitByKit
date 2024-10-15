package com.example.fitbykit.Notifications

import android.content.Context
import androidx.lifecycle.ViewModel
import java.util.Calendar

class NotificationViewModel(private val notificationRepository: NotificationRepository) : ViewModel() {
    fun scheduleDailyNotifications(context: Context) {
        // Morning notification
        val morningTime = getTimeInMillis(8, 0)
        notificationRepository.scheduleNotification(context, morningTime, "Good morning! Start your day with a healthy mindset!")

        // Afternoon notification
        val afternoonTime = getTimeInMillis(14, 0)
        notificationRepository.scheduleNotification(context, afternoonTime, "Good afternoon! Don't forget to hydrate and take a break.")

        // Evening notification
        val eveningTime = getTimeInMillis(18, 0)
        notificationRepository.scheduleNotification(context, eveningTime, "Good evening! Time to wind down and reflect on your day.")
    }

    private fun getTimeInMillis(hour: Int, minute: Int): Long {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
        }
        return calendar.timeInMillis
    }
}