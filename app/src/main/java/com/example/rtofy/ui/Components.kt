package com.example.rtofy.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item { DashboardCard(ui) }
            item {
                QuickLogCard(
                    onYes = { vm.markToday(true) },
                    onNo = { vm.markToday(false) }
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SettingsScreen(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { SettingsCard(ui.fyStartMonth, onSave = { vm.setFyStartMonth(it) }) }
        item { HolidaysCard(ui, onAdd = { vm.addHoliday(it) }, onRemove = { vm.removeHoliday(it) }) }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditScreen(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()
    val fmt = DateTimeFormatter.ISO_LOCAL_DATE

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item {
            Text(
                "Edit Attendance (this quarter)",
                style = MaterialTheme.typography.titleLarge
            )
        }

        items(ui.dates) { d ->
            ElevatedCard(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = d.format(fmt),
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Switch(
                        checked = ui.attendanceMap[d] == true,
                        onCheckedChange = { vm.setAttendance(d, it) }
                    )
                }
            }
        }
    }
}

@Composable
fun SettingsCard(fyStart: Int, onSave: (Int) -> Unit) {
    var fyText by remember(fyStart) { mutableStateOf(fyStart.toString()) }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
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
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default,
                shape = RoundedCornerShape(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        fyText.toIntOrNull()?.let {
                            if (it in 1..12) onSave(it)
                        }
                    },
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Save")
                }
            }

            Text(
                "Morning prompt ~8:30 AM (device time).",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private val shortFmt = DateTimeFormatter.ofPattern("MMM d")

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashboardCard(ui: UiState) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = "Return to Office Tracker",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Q4 FY · ${ui.qStart.format(shortFmt)} – ${ui.qEnd.format(shortFmt)}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                RtoSummaryPanel(
                    title = "To-Date",
                    progress = ui.rtoToDatePct,
                    percentText = ui.rtoToDatePctString,
                    businessDays = ui.bizToDate,
                    officeDays = ui.officeToDate,
                    modifier = Modifier.weight(1f)
                )

                RtoSummaryPanel(
                    title = "Full Qtr",
                    progress = ui.rtoFullPct,
                    percentText = ui.rtoFullPctString,
                    businessDays = ui.bizFull,
                    officeDays = ui.officeFull,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun RtoSummaryPanel(
    title: String,
    progress: Float,
    percentText: String,
    businessDays: Int,
    officeDays: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 1.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            CompactRtoGauge(
                progress = progress,
                percentText = percentText
            )

            MiniStatRow(
                label = "Business Days",
                value = businessDays.toString()
            )

            HorizontalDivider(
                thickness = 0.8.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
            )

            MiniStatRow(
                label = "Office Days",
                value = officeDays.toString()
            )
        }
    }
}

@Composable
fun CompactRtoGauge(
    progress: Float,
    percentText: String
) {
    val safeProgress = progress.coerceIn(0f, 1f)
    val progressColor = gaugeColor(safeProgress)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(105.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            val strokeWidth = 8.dp.toPx()
            val gaugeDiameter = size.width * 0.7f
            val left = (size.width - gaugeDiameter) / 2f
            val top = (-6).dp.toPx()

            drawArc(
                color = Color(0xFFE8E8EC),
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(left, top),
                size = Size(gaugeDiameter, gaugeDiameter),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )

            drawArc(
                color = progressColor,
                startAngle = 180f,
                sweepAngle = 180f * safeProgress,
                useCenter = false,
                topLeft = Offset(left, top),
                size = Size(gaugeDiameter, gaugeDiameter),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }

        Column(
            modifier = Modifier.padding(top = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = percentText,
                style = MaterialTheme.typography.titleMedium,
                color = progressColor
            )
            val status = rtoStatusLabel(safeProgress)
            Text(
                text = status.replace(" ", "\n"),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun MiniStatRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HolidaysCard(
    ui: UiState,
    onAdd: (LocalDate) -> Unit,
    onRemove: (LocalDate) -> Unit
) {
    val fmt = DateTimeFormatter.ISO_LOCAL_DATE
    var holidayText by remember { mutableStateOf(LocalDate.now().format(fmt)) }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Holidays",
                style = MaterialTheme.typography.titleLarge
            )

            OutlinedTextField(
                value = holidayText,
                onValueChange = { holidayText = it },
                label = { Text("YYYY-MM-DD") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        runCatching { LocalDate.parse(holidayText, fmt) }.onSuccess(onAdd)
                    },
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text("Add")
                }
            }

            if (ui.holidays.isEmpty()) {
                Text(
                    text = "No holidays added yet.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                ui.holidays.forEach { d ->
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        tonalElevation = 1.dp
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                d.toString(),
                                style = MaterialTheme.typography.bodyLarge
                            )
                            TextButton(onClick = { onRemove(d) }) {
                                Text("Remove")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun QuickLogCard(onYes: () -> Unit, onNo: () -> Unit) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 3.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = "Quick Log Today",
                style = MaterialTheme.typography.titleMedium
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                PillButton(
                    text = "Yes",
                    onClick = onYes,
                    containerColor = Color(0xFF8FAF7C),
                    contentColor = Color.White,
                    leading = "✓"
                )

                PillButton(
                    text = "No",
                    onClick = onNo,
                    containerColor = Color(0xFFF1EEF2),
                    contentColor = Color(0xFF4A4452),
                    leading = "✕"
                )
            }
        }
    }
}

@Composable
fun PillButton(
    text: String,
    onClick: () -> Unit,
    containerColor: Color,
    contentColor: Color,
    leading: String
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(999.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        modifier = Modifier.height(34.dp)
    ) {
        Text(
            text = "$leading  $text",
            style = MaterialTheme.typography.labelLarge
        )
    }
}

private fun gaugeColor(progress: Float): Color {
    return when {
        progress < 0.4f -> Color(0xFFD32F2F)
        progress < 0.5f -> Color(0xFFF9A825)
        else -> Color(0xFF3D8B40)
    }
}

private fun rtoStatusLabel(progress: Float): String {
    return when {
        progress < 0.4f -> "Needs Attention"
        progress < 0.5f -> "Doing Okay"
        else -> "On Track"
    }
}