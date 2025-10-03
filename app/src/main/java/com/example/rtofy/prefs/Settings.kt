package com.example.rtofy.prefs

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

object Keys { val FyStartMonth = intPreferencesKey("fy_start_month") }

class SettingsRepo(private val context: Context) {
    val fyStartMonthFlow = context.dataStore.data.map { it[Keys.FyStartMonth] ?: 4 }
    suspend fun setFyStartMonth(m: Int) {
        require(m in 1..12); context.dataStore.edit { it[Keys.FyStartMonth] = m }
    }
    companion object { fun get(ctx: Context) = SettingsRepo(ctx.applicationContext) }
}
