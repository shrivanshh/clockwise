package com.example.rtofy.notify
import androidx.work.*
import java.time.*
import java.util.concurrent.TimeUnit
object Scheduler {
    fun scheduleDailyPrompt(workManager: WorkManager, hour: Int = 8, minute: Int = 30) {
        val now = ZonedDateTime.now()
        var next = now.withHour(hour).withMinute(minute).withSecond(0).withNano(0)
        if (!next.isAfter(now)) next = next.plusDays(1)
        val initialDelay = Duration.between(now, next).toMinutes()
        val request = PeriodicWorkRequestBuilder<DailyPromptWorker>(24, TimeUnit.HOURS)
            .setInitialDelay(initialDelay, TimeUnit.MINUTES)
            .build()
        workManager.enqueueUniquePeriodicWork("daily_rto_prompt", ExistingPeriodicWorkPolicy.UPDATE, request)
    }
}
