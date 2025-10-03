package com.example.rtofy.ui
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rtofy.data.Repo
import com.example.rtofy.prefs.SettingsRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.time.LocalDate

data class UiState(
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
    val attendanceMap: Map<LocalDate, Boolean> = emptyMap()
)

@OptIn(ExperimentalCoroutinesApi::class)
class RtoViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = Repo.get(app)
    private val settings = SettingsRepo.get(app)

    private val refresh = MutableSharedFlow<Unit>(extraBufferCapacity = 1)

    val ui: StateFlow<UiState> = combine(
        settings.fyStartMonthFlow,
        repo.holidaysFlow(),
        refresh.onStart { emit(Unit) }
    ) { fy, holidays, _ -> Pair(fy, holidays.map { it.date }) }.flatMapLatest { (fy, holidays) ->
        flow {
            val today = LocalDate.now()
            val (qs, qe) = repo.currentFyQuarter(today, fy)

            val bizTo = repo.businessDaysBetween(qs, minOf(today, qe))
            val officeTo = repo.officeDaysBetween(qs, minOf(today, qe))

            val bizFull = repo.businessDaysBetween(qs, qe)
            val officeFull = repo.officeDaysBetween(qs, qe)

            val holidaySet = holidays.toHashSet()
val dates = generateSequence(qs) { it.plusDays(1) }
    .takeWhile { !it.isAfter(qe) }
    .filter { d ->
        val wd = d.dayOfWeek.value // 1=Mon ... 7=Sun
        (wd in 1..5) && !holidaySet.contains(d)
    }.toList()

            // Build attendance map from DB flow (one-shot collect)
            val entries = repo.attendanceFlowBetween(qs, qe).first()
            val map = entries.associate { it.date to it.wentToOffice }

            emit(
                UiState(
                    fyStartMonth = fy,
                    qStart = qs,
                    qEnd = qe,
                    bizToDate = bizTo,
                    officeToDate = officeTo,
                    rtoToDatePctString = pct(officeTo, bizTo),
                    bizFull = bizFull,
                    officeFull = officeFull,
                    rtoFullPctString = pct(officeFull, bizFull),
                    holidays = holidays,
                    dates = dates,
                    attendanceMap = map
                )
            )
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState())

    fun setFyStartMonth(m: Int) = viewModelScope.launch { settings.setFyStartMonth(m); refresh.tryEmit(Unit) }
    fun addHoliday(d: LocalDate) = viewModelScope.launch { repo.addHoliday(d); refresh.tryEmit(Unit) }
    fun removeHoliday(d: LocalDate) = viewModelScope.launch { repo.deleteHoliday(d); refresh.tryEmit(Unit) }
    fun markToday(went: Boolean) = viewModelScope.launch { repo.markToday(went); refresh.tryEmit(Unit) }
    fun setAttendance(date: LocalDate, went: Boolean) = viewModelScope.launch { repo.setAttendance(date, went); refresh.tryEmit(Unit) }

    companion object {
        fun pct(n: Int, d: Int): String =
            if (d == 0) "0%" else NumberFormat.getPercentInstance().apply { maximumFractionDigits = 1 }.format(n.toDouble()/d)
    }
}
