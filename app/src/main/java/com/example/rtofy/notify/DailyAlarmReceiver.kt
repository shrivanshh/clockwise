package com.example.rtofy.notify

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.rtofy.R

class DailyAlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent?) {
        showNotification(context)
        AlarmScheduler.scheduleNextMorningPrompt(context)
    }

    private fun showNotification(ctx: Context) {
        val channelId = "rto_prompt"
        val notificationId = 1001
        val nm = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "RTO Prompt",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Daily return-to-office reminder"
            }
            nm.createNotificationChannel(channel)
        }

        val yesIntent = Intent(ctx, NotificationActionReceiver::class.java).apply {
            putExtra("went", true)
            putExtra("nid", notificationId)
        }

        val noIntent = Intent(ctx, NotificationActionReceiver::class.java).apply {
            putExtra("went", false)
            putExtra("nid", notificationId)
        }

        val yesPI = PendingIntent.getBroadcast(
            ctx,
            1,
            yesIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val noPI = PendingIntent.getBroadcast(
            ctx,
            2,
            noIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(ctx, channelId)
            .setSmallIcon(R.mipmap.ic_launcher) // replace later with proper notification icon
            .setContentTitle("Are you going to office today?")
            .setContentText("Tap Yes or No")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .addAction(0, "Yes", yesPI)
            .addAction(0, "No", noPI)
            .build()

        nm.notify(notificationId, notification)
    }
}