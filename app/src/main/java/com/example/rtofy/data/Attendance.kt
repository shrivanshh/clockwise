package com.example.rtofy.data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
@Entity(tableName = "attendance")
data class Attendance(@PrimaryKey val date: LocalDate, val wentToOffice: Boolean)
