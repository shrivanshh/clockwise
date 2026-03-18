package com.example.rtofy.prefs

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

class SettingsRepo private constructor(private val context: Context) {

    companion object {
        private val FY_START_MONTH = intPreferencesKey("fy_start_month")
        private val NOTIFICATION_HOUR = intPreferencesKey("notification_hour")
        private val NOTIFICATION_MINUTE = intPreferencesKey("notification_minute")

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: SettingsRepo? = null

        fun get(context: Context): SettingsRepo =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: SettingsRepo(context.applicationContext).also { INSTANCE = it }
            }
    }

    val fyStartMonthFlow = context.dataStore.data.map {
        it[FY_START_MONTH] ?: 4
    }

    val notificationHourFlow = context.dataStore.data.map {
        it[NOTIFICATION_HOUR] ?: 8
    }

    val notificationMinuteFlow = context.dataStore.data.map {
        it[NOTIFICATION_MINUTE] ?: 30
    }

    suspend fun setFyStartMonth(month: Int) {
        context.dataStore.edit {
            it[FY_START_MONTH] = month
        }
    }

    suspend fun setNotificationTime(hour: Int, minute: Int) {
        context.dataStore.edit {
            it[NOTIFICATION_HOUR] = hour
            it[NOTIFICATION_MINUTE] = minute
        }
    }
}