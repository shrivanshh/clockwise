package com.example.rtofy.data
import android.content.Context
import androidx.room.*
@Database(entities = [Attendance::class, Holiday::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun attendanceDao(): AttendanceDao
    abstract fun holidayDao(): HolidayDao
    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun get(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "rtofy.db").build().also { INSTANCE = it }
            }
    }
}
