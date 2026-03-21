package com.example.rtofy.ui.rto

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AttendanceCalendarCard(
    month: YearMonth,
    holidays: Set<LocalDate>,
    attendanceMap: Map<LocalDate, Boolean>,
    onPreviousMonth: () -> Unit,
    onNextMonth: () -> Unit,
    onDayTap: (LocalDate) -> Unit,
    onDayLongPress: (LocalDate) -> Unit
) {
    val days = remember(month) { buildCalendarCells(month) }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    "Attendance & Holidays",
                    style = MaterialTheme.typography.titleLarge
                )

                Text(
                    text = "Tap to mark Office/No Office & Long press to add or remove a holiday.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    FilledTonalButton(
                        onClick = onPreviousMonth,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.size(width = 56.dp, height = 44.dp)
                    ) {
                        Text(
                            text = "◀",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Text(
                        text = month.month.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " " + month.year,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    FilledTonalButton(
                        onClick = onNextMonth,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.size(width = 56.dp, height = 44.dp)
                    ) {
                        Text(
                            text = "▶",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }

            Surface(
                shape = RoundedCornerShape(18.dp),
                tonalElevation = 1.dp
            ) {
                Column(
                    modifier = Modifier.padding(14.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    WeekHeader()

                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        days.chunked(7).forEach { week ->
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                week.forEach { dateOrNull ->
                                    Box(
                                        modifier = Modifier.weight(1f),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (dateOrNull == null) {
                                            Spacer(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .aspectRatio(1f)
                                            )
                                        } else {
                                            CalendarDayCell(
                                                date = dateOrNull,
                                                status = resolveDayStatus(
                                                    date = dateOrNull,
                                                    holidays = holidays,
                                                    attendanceMap = attendanceMap
                                                ),
                                                isToday = dateOrNull == LocalDate.now(),
                                                onTap = { onDayTap(dateOrNull) },
                                                onLongPress = { onDayLongPress(dateOrNull) }
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    CalendarLegend()
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeekHeader() {
    val days = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        days.forEach { label ->
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

enum class CalendarDayStatus {
    OFFICE,
    NO_OFFICE,
    HOLIDAY,
    WEEKEND,
    EMPTY
}

@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarDayCell(
    date: LocalDate,
    status: CalendarDayStatus,
    isToday: Boolean,
    onTap: () -> Unit,
    onLongPress: () -> Unit
) {
    val bgColor = when (status) {
        CalendarDayStatus.OFFICE -> Color(0xFFDCEED4)
        CalendarDayStatus.NO_OFFICE -> Color(0xFFF5D6D6)
        CalendarDayStatus.HOLIDAY -> Color(0xFFE6E0F8)
        CalendarDayStatus.WEEKEND -> Color(0xFFEAE7E2)
        CalendarDayStatus.EMPTY -> MaterialTheme.colorScheme.surface
    }

    val textColor = when (status) {
        CalendarDayStatus.OFFICE -> Color(0xFF2E5D34)
        CalendarDayStatus.NO_OFFICE -> Color(0xFF8A3030)
        CalendarDayStatus.HOLIDAY -> Color(0xFF5C4E87)
        CalendarDayStatus.WEEKEND -> Color(0xFF6B6257)
        CalendarDayStatus.EMPTY -> MaterialTheme.colorScheme.onSurface
    }

    val borderColor =
        if (isToday) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(14.dp))
            .combinedClickable(
                onClick = onTap,
                onLongClick = onLongPress
            ),
        shape = RoundedCornerShape(14.dp),
        color = bgColor,
        border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = date.dayOfMonth.toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = textColor,
                fontWeight = if (isToday) FontWeight.Bold else FontWeight.Medium
            )

            val marker = when (status) {
                CalendarDayStatus.OFFICE -> "✓"
                CalendarDayStatus.NO_OFFICE -> "✕"
                CalendarDayStatus.HOLIDAY -> "H"
                CalendarDayStatus.WEEKEND -> ""
                CalendarDayStatus.EMPTY -> ""
            }

            Box(
                modifier = Modifier.size(16.dp),
                contentAlignment = Alignment.Center
            ) {
                if (marker.isNotEmpty()) {
                    Text(
                        text = marker,
                        style = MaterialTheme.typography.labelSmall,
                        color = textColor,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Composable
fun CalendarLegend() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(
            "Legend",
            style = MaterialTheme.typography.labelLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            LegendItem(Color(0xFFDCEED4), "Office")
            LegendItem(Color(0xFFF5D6D6), "No Office")
            LegendItem(Color(0xFFE6E0F8), "Holiday")
            LegendItem(Color(0xFFEAE7E2), "Weekend")
        }
    }
}

@Composable
fun LegendItem(color: Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .clip(CircleShape)
                .background(color)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun resolveDayStatus(
    date: LocalDate,
    holidays: Set<LocalDate>,
    attendanceMap: Map<LocalDate, Boolean>
): CalendarDayStatus {
    return when {
        holidays.contains(date) -> CalendarDayStatus.HOLIDAY
        date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY ->
            CalendarDayStatus.WEEKEND
        attendanceMap[date] == true -> CalendarDayStatus.OFFICE
        attendanceMap[date] == false -> CalendarDayStatus.NO_OFFICE
        else -> CalendarDayStatus.EMPTY
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun buildCalendarCells(month: YearMonth): List<LocalDate?> {
    val firstDay = month.atDay(1)
    val daysInMonth = month.lengthOfMonth()

    val leadingEmpty = firstDay.dayOfWeek.value - 1
    val result = mutableListOf<LocalDate?>()

    repeat(leadingEmpty) { result.add(null) }
    for (day in 1..daysInMonth) {
        result.add(month.atDay(day))
    }
    while (result.size % 7 != 0) {
        result.add(null)
    }

    return result
}