package com.example.rtofy.notify
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import android.app.PendingIntent
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.rtofy.R
class DailyPromptWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result { showNotification(); return Result.success() }
    private fun showNotification() {
        val ctx = applicationContext
        val channelId = "rto_prompt"
        val nm = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            nm.createNotificationChannel(NotificationChannel(channelId, "RTO Prompt", NotificationManager.IMPORTANCE_DEFAULT))
        }
        val nid = 1001
        val yesIntent = Intent(ctx, NotificationActionReceiver::class.java).apply { putExtra("went", true); putExtra("nid", nid) }
        val noIntent = Intent(ctx, NotificationActionReceiver::class.java).apply { putExtra("went", false); putExtra("nid", nid) }
        val yesPI = PendingIntent.getBroadcast(ctx, 1, yesIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val noPI = PendingIntent.getBroadcast(ctx, 2, noIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val notif = NotificationCompat.Builder(ctx, channelId)
            .setSmallIcon(R.drawable.ic_stat_name)
            .setContentTitle("Are you going to office today?")
            .setContentText("Tap Yes or No")
            .addAction(0, "Yes", yesPI)
            .addAction(0, "No", noPI)
            .setAutoCancel(true)
            .build()
        nm.notify(nid, notif)
    }
}
