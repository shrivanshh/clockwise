package com.example.rtofy.ui.tasks

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rtofy.data.Repo
import com.example.rtofy.notify.AlarmScheduler
import com.example.rtofy.prefs.SettingsRepo
import com.example.rtofy.ui.rto.RtoViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.time.LocalDate

@OptIn(ExperimentalCoroutinesApi::class)
class TaskViewModel(app: Application) : AndroidViewModel(app) {
}