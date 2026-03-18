package com.example.rtofy.ui
import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rtofy.data.Repo
import com.example.rtofy.notify.AlarmScheduler
import com.example.rtofy.prefs.SettingsRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.time.LocalDate

data class UiState @RequiresApi(Build.VERSION_CODES.O) constructor(
    val fyStartMonth: Int = 4,
    val qStart: LocalDate = LocalDate.now(),
    val qEnd: LocalDate = LocalDate.now(),
    val bizToDate: Int = 0,
    val officeToDate: Int = 0,
    val rtoToDatePctString: String = "0%",
    val bizFull: Int = 0,
    val officeFull: Int = 0,
    val rtoFullPctString: String = "0%",
    val holidays: List<LocalDate> = emptyList(),
    val dates: List<LocalDate> = emptyList(),
    val attendanceMap: Map<LocalDate, Boolean> = emptyMap(),
    val rtoToDatePct: Float = 0f,       // 0.0f to 1.0f
    val rtoFullPct: Float = 0f,

    val notificationHour: Int = 8,
    val notificationMinute: Int = 30
)

@OptIn(ExperimentalCoroutinesApi::class)
class RtoViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = Repo.get(app)
    private val settings = SettingsRepo.get(app)

    private val refresh = MutableSharedFlow<Unit>(extraBufferCapacity = 1)

    @RequiresApi(Build.VERSION_CODES.O)
    val ui: StateFlow<UiState> =
        combine(
            settings.fyStartMonthFlow,
            settings.notificationHourFlow,
            settings.notificationMinuteFlow,
            repo.holidaysFlow(),
            refresh.onStart { emit(Unit) }
        ) { fy, notifHour, notifMinute, holidays, _ ->
            Quadruple(fy, notifHour, notifMinute, holidays.map { it.date })
        }.flatMapLatest { (fy, notifHour, notifMinute, holidays) ->
            val today = LocalDate.now()
            val (qs, qe) = repo.currentFyQuarter(today, fy)

            repo.attendanceFlowBetween(qs, qe).map { entries ->
                val bizTo = repo.businessDaysBetween(qs, minOf(today, qe))
                val officeTo = repo.officeDaysBetween(qs, minOf(today, qe))

                val bizFull = repo.businessDaysBetween(qs, qe)
                val officeFull = repo.officeDaysBetween(qs, qe)

                val holidaySet = holidays.toHashSet()

                val dates = generateSequence(qs) { it.plusDays(1) }
                    .takeWhile { !it.isAfter(qe) }
                    .filter { d ->
                        val wd = d.dayOfWeek.value
                        (wd in 1..5) && !holidaySet.contains(d)
                    }
                    .toList()

                val map = entries.associate { it.date to it.wentToOffice }

                UiState(
                    fyStartMonth = fy,
                    qStart = qs,
                    qEnd = qe,
                    bizToDate = bizTo,
                    officeToDate = officeTo,
                    rtoToDatePctString = pctString(officeTo, bizTo),
                    bizFull = bizFull,
                    officeFull = officeFull,
                    rtoFullPctString = pctString(officeFull, bizFull),
                    holidays = holidays,
                    dates = dates,
                    attendanceMap = map,
                    rtoToDatePct = pct(officeTo, bizTo),
                    rtoFullPct = pct(officeFull, bizFull),
                    notificationHour = notifHour,
                    notificationMinute = notifMinute
                )
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            UiState()
        )

    data class Quadruple<A, B, C, D>(
        val first: A,
        val second: B,
        val third: C,
        val fourth: D
    )

    fun setNotificationTime(hour: Int, minute: Int) = viewModelScope.launch {
        settings.setNotificationTime(hour, minute)
        AlarmScheduler.scheduleNextMorningPrompt(getApplication(), hour, minute)
        refresh.tryEmit(Unit)
    }

    fun setFyStartMonth(m: Int) = viewModelScope.launch {
        settings.setFyStartMonth(m)
        refresh.tryEmit(Unit)
    }

    fun addHoliday(d: LocalDate) = viewModelScope.launch {
        repo.addHoliday(d)
        refresh.tryEmit(Unit)
    }

    fun removeHoliday(d: LocalDate) = viewModelScope.launch {
        repo.deleteHoliday(d)
        refresh.tryEmit(Unit)
    }

    fun markToday(went: Boolean) = viewModelScope.launch {
        repo.markToday(went)
        refresh.tryEmit(Unit)
    }

    fun setAttendance(date: LocalDate, went: Boolean) = viewModelScope.launch {
        repo.setAttendance(date, went)
        refresh.tryEmit(Unit)
    }

    companion object {
        fun pctString(n: Int, d: Int): String =
            if (d == 0) {
                "0%"
            } else {
                NumberFormat.getPercentInstance().apply {
                    maximumFractionDigits = 1
                }.format(n.toDouble() / d.toDouble())
            }

        fun pct(n: Int, d: Int): Float =
            if (d == 0) 0f else n.toFloat() / d.toFloat()
    }
}
