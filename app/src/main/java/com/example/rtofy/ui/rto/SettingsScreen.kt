package com.example.rtofy.ui.rto

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rtofy.ui.common.NotificationTimePickerDialog
import com.example.rtofy.ui.rto.RtoViewModel
import java.time.DayOfWeek
import java.time.YearMonth

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SettingsScreen(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()
    var visibleMonth by remember { mutableStateOf(YearMonth.now()) }

    LazyColumn(
        modifier = Modifier.Companion
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            SettingsCard(
                fyStart = ui.fyStartMonth,
                notificationHour = ui.notificationHour,
                notificationMinute = ui.notificationMinute,
                onSaveFy = { vm.setFyStartMonth(it) },
                onSaveNotificationTime = { hour, minute ->
                    vm.setNotificationTime(hour, minute)
                }
            )
        }
        item {
            AttendanceCalendarCard(
                month = visibleMonth,
                holidays = ui.holidays.toSet(),
                attendanceMap = ui.attendanceMap,
                onPreviousMonth = { visibleMonth = visibleMonth.minusMonths(1) },
                onNextMonth = { visibleMonth = visibleMonth.plusMonths(1) },
                onDayTap = { date ->
                    val isWeekend = date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY
                    val isHoliday = ui.holidays.contains(date)

                    if (isWeekend || isHoliday) return@AttendanceCalendarCard

                    when (ui.attendanceMap[date]) {
                        null -> vm.setAttendance(date, true)
                        true -> vm.setAttendance(date, false)
                        false -> vm.clearAttendance(date)
                    }
                },
                onDayLongPress = { date ->
                    val isWeekend = date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY
                    if (isWeekend) return@AttendanceCalendarCard

                    if (ui.holidays.contains(date)) {
                        vm.removeHoliday(date)
                    } else {
                        vm.addHoliday(date)
                    }
                }
            )
        }
    }
}

@Composable
fun SettingsCard(
    fyStart: Int,
    notificationHour: Int,
    notificationMinute: Int,
    onSaveFy: (Int) -> Unit,
    onSaveNotificationTime: (Int, Int) -> Unit
) {
    var fyText by remember(fyStart) { mutableStateOf(fyStart.toString()) }
    var showTimePicker by remember { mutableStateOf(false) }

    ElevatedCard(
        modifier = Modifier.Companion.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.Companion.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Settings",
                style = MaterialTheme.typography.titleLarge
            )

            OutlinedTextField(
                value = fyText,
                onValueChange = { fyText = it },
                label = { Text("Fiscal Year Start Month (1–12)") },
                singleLine = true,
                modifier = Modifier.Companion.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Companion.Default,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
            )

            Row(
                modifier = Modifier.Companion.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        fyText.toIntOrNull()?.let {
                            if (it in 1..12) onSaveFy(it)
                        }
                    },
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
                ) {
                    Text("Save")
                }
            }

            HorizontalDivider()

            Text(
                "Notification Time",
                style = MaterialTheme.typography.titleMedium
            )

            Surface(
                shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp),
                tonalElevation = 1.dp
            ) {
                Row(
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Companion.CenterVertically
                ) {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Daily Prompt",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            formatTime(notificationHour, notificationMinute),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    OutlinedButton(
                        onClick = { showTimePicker = true },
                        shape = androidx.compose.foundation.shape.RoundedCornerShape(14.dp)
                    ) {
                        Text("Change")
                    }
                }
            }
        }
    }

    if (showTimePicker) {
        NotificationTimePickerDialog(
            initialHour = notificationHour,
            initialMinute = notificationMinute,
            onDismiss = { showTimePicker = false },
            onConfirm = { hour, minute ->
                showTimePicker = false
                onSaveNotificationTime(hour, minute)
            }
        )
    }
}

private fun formatTime(hour: Int, minute: Int): String {
    val amPm = if (hour < 12) "AM" else "PM"
    val displayHour = when {
        hour == 0 -> 12
        hour > 12 -> hour - 12
        else -> hour
    }
    return "%d:%02d %s".format(displayHour, minute, amPm)
}