package com.example.fitbykit.Notifications

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.fitbykit.R

class ReminderBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val message = intent.getStringExtra("NOTIFICATION_MESSAGE") ?: "Stay healthy!"

        val notificationId = System.currentTimeMillis().toInt()
        val builder = NotificationCompat.Builder(context, "fitbykitChannel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("FitByKit")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(notificationId, builder.build())
    }
}