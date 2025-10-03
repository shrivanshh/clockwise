package com.example.rtofy.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun HomeScreen(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()
    LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item { DashboardCard(ui) }
        item { QuickLogCard(onYes = { vm.markToday(true) }, onNo = { vm.markToday(false) }) }
    }
}

@Composable
fun SettingsScreen(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()
    LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        item { SettingsCard(ui.fyStartMonth, onSave = { vm.setFyStartMonth(it) }) }
        item { HolidaysCard(ui, onAdd = { vm.addHoliday(it) }, onRemove = { vm.removeHoliday(it) }) }
    }
}

@Composable
fun EditScreen(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()
    val fmt = DateTimeFormatter.ISO_LOCAL_DATE
    LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        item { Text("Edit Attendance (this quarter)", style = MaterialTheme.typography.titleMedium) }
        items(ui.dates) { d ->
            val checked = ui.attendanceMap[d] == true
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(d.format(fmt))
                Switch(checked = checked, onCheckedChange = { vm.setAttendance(d, it) })
            }
            HorizontalDivider()
        }
    }
}

@Composable
fun SettingsCard(fyStart: Int, onSave: (Int) -> Unit) {
    Card {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Settings", style = MaterialTheme.typography.titleMedium)
            var fyText by remember { mutableStateOf(fyStart.toString()) }
            Row {
                OutlinedTextField(
                    value = fyText,
                    onValueChange = { fyText = it },
                    label = { Text("Fiscal Year Start Month (1–12)") },
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions.Default
                )
                Spacer(Modifier.width(8.dp))
                Button(onClick = { fyText.toIntOrNull()?.let { if (it in 1..12) onSave(it) } }) { Text("Save") }
            }
            Text("Morning prompt ~8:30 AM (device time).")
        }
    }
}

@Composable
fun DashboardCard(ui: UiState) {
    Card {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Dashboard", style = MaterialTheme.typography.titleMedium)
            Text("Quarter: ${ui.qStart} → ${ui.qEnd}")
            Text("Business days (to date): ${ui.bizToDate}")
            Text("Office days (to date): ${ui.officeToDate}")
            Text("RTO % (to date): ${ui.rtoToDatePctString}")
            HorizontalDivider()
            Text("Business days (full qtr): ${ui.bizFull}")
            Text("Office days (full qtr): ${ui.officeFull}")
            Text("RTO % (full qtr): ${ui.rtoFullPctString}")
        }
    }
}

@Composable
fun HolidaysCard(ui: UiState, onAdd: (LocalDate) -> Unit, onRemove: (LocalDate) -> Unit) {
    val fmt = DateTimeFormatter.ISO_LOCAL_DATE
    Card {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Holidays", style = MaterialTheme.typography.titleMedium)
            var holidayText by remember { mutableStateOf(LocalDate.now().format(fmt)) }
            Row {
                OutlinedTextField(
                    value = holidayText,
                    onValueChange = { holidayText = it },
                    label = { Text("YYYY-MM-DD") },
                    singleLine = true,
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(8.dp))
                Button(onClick = {
                    runCatching { LocalDate.parse(holidayText, fmt) }.onSuccess(onAdd)
                }) { Text("Add") }
            }
            Spacer(Modifier.height(8.dp))
            ui.holidays.forEach { d ->
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(d.toString())
                    TextButton(onClick = { onRemove(d) }) { Text("Remove") }
                }
            }
        }
    }
}

@Composable
fun QuickLogCard(onYes: () -> Unit, onNo: () -> Unit) {
    Card {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("Quick Log Today", style = MaterialTheme.typography.titleMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = onYes) { Text("Yes") }
                Button(onClick = onNo) { Text("No") }
            }
            Text("You can also use the notification actions each morning.")
        }
    }
}
