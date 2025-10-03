package com.example.rtofy.data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
@Entity(tableName = "holidays")
data class Holiday(@PrimaryKey(autoGenerate = true) val id: Long = 0, val date: LocalDate)
