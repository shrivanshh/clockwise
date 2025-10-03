package com.example.rtofy.data
import androidx.room.TypeConverter
import java.time.LocalDate
class Converters {
    @TypeConverter fun fromEpochDay(epoch: Long?): LocalDate? = epoch?.let { LocalDate.ofEpochDay(it) }
    @TypeConverter fun localDateToEpochDay(date: LocalDate?): Long? = date?.toEpochDay()
}
