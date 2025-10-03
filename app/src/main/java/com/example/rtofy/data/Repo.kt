package com.example.rtofy.data
import kotlinx.coroutines.flow.first
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import kotlinx.coroutines.flow.Flow

class Repo(private val db: AppDatabase) {
    private val attendance = db.attendanceDao()
    private val holidays = db.holidayDao()
    suspend fun markToday(went: Boolean, today: LocalDate = LocalDate.now()) { attendance.upsert(Attendance(today, went)) }
    suspend fun setAttendance(date: LocalDate, went: Boolean) { attendance.upsert(Attendance(date, went)) }
    fun holidaysFlow() = holidays.all()
    suspend fun addHoliday(date: LocalDate) = holidays.insert(Holiday(date = date))
    suspend fun deleteHoliday(date: LocalDate) = holidays.deleteByDate(date)
    fun currentFyQuarter(today: LocalDate, fyStartMonth: Int): Pair<LocalDate, LocalDate> {
        require(fyStartMonth in 1..12)
        val month = today.monthValue
        val shifted = ((month - fyStartMonth + 12) % 12) + 1
        val qIndex = (shifted - 1) / 3
        val startMonth = ((fyStartMonth - 1) + qIndex * 3) % 12 + 1
        val startYear = if (startMonth > month) today.year - 1 else today.year
        val start = LocalDate.of(startYear, startMonth, 1)
        val endMonth = ((start.monthValue - 1 + 2) % 12) + 1
        val endYear = if (endMonth < start.monthValue) start.year + 1 else start.year
        val end = YearMonth.of(endYear, endMonth).atEndOfMonth()
        return start to end
    }
    suspend fun businessDaysBetween(a: LocalDate, b: LocalDate): Int {
        val holidaySet = holidays.all().first().map { it.date }.toHashSet()
        var d = a; var count = 0
        while (!d.isAfter(b)) {
            val wd = d.dayOfWeek
            val isWeekend = (wd == DayOfWeek.SATURDAY || wd == DayOfWeek.SUNDAY)
            if (!isWeekend && !holidaySet.contains(d)) count++
            d = d.plusDays(1)
        }
        return count
    }
    fun attendanceFlowBetween(a: LocalDate, b: LocalDate): Flow<List<Attendance>> =
        db.attendanceDao().entriesBetween(a, b)

    suspend fun officeDaysBetween(a: LocalDate, b: LocalDate): Int {
        val list = attendance.entriesBetween(a, b).first()
        return list.count { it.wentToOffice }
    }
    companion object { fun get(context: android.content.Context) = Repo(AppDatabase.get(context)) }
}
