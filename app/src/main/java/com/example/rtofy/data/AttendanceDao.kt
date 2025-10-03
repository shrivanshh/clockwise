package com.example.rtofy.data
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
@Dao
interface AttendanceDao {
    @Upsert suspend fun upsert(entry: Attendance)
    @Query("SELECT * FROM attendance WHERE date BETWEEN :start AND :end")
    fun entriesBetween(start: LocalDate, end: LocalDate): Flow<List<Attendance>>
    @Query("SELECT * FROM attendance WHERE date = :date LIMIT 1")
    suspend fun get(date: LocalDate): Attendance?
}
@Dao
interface HolidayDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE) suspend fun insert(h: Holiday)
    @Query("DELETE FROM holidays WHERE date = :date") suspend fun deleteByDate(date: LocalDate)
    @Query("SELECT * FROM holidays") fun all(): Flow<List<Holiday>>
}
