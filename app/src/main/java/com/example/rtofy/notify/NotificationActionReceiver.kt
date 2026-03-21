package com.example.rtofy.notify

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationManagerCompat
import com.example.rtofy.data.Repo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotificationActionReceiver : BroadcastReceiver() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        val went = intent.getBooleanExtra("went", false)
        val notificationId = intent.getIntExtra("nid", 1001)

        val pendingResult = goAsync()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                Repo.get(context).markToday(went)
                NotificationManagerCompat.from(context).cancel(notificationId)
            } finally {
                pendingResult.finish()
            }
        }
    }
}