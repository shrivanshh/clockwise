package com.example.rtofy.ui.rto

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.rtofy.ui.common.ModuleCard
import com.example.rtofy.ui.common.PillButton
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.layout.padding
import com.example.rtofy.ui.rto.RtoViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RtoModule(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()

    ModuleCard {
        Text(
            text = "Return to Office Tracker",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "${ui.qStart.format(shortFmt)} – ${ui.qEnd.format(shortFmt)}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(
            modifier = Modifier.Companion.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            RtoSummaryPanel(
                title = "To-Date",
                progress = ui.rtoToDatePct,
                percentText = ui.rtoToDatePctString,
                businessDays = ui.bizToDate,
                officeDays = ui.officeToDate,
                modifier = Modifier.Companion.weight(1f)
            )

            RtoSummaryPanel(
                title = "Full Quarter",
                progress = ui.rtoFullPct,
                percentText = ui.rtoFullPctString,
                businessDays = ui.bizFull,
                officeDays = ui.officeFull,
                modifier = Modifier.Companion.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Did you logged your Attendance for Today?",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            PillButton(
                text = "Yes",
                onClick = { if (ui.todayStatus == true) vm.clearToday()
                else vm.markToday(true) },
                containerColor =
                    if (ui.todayStatus == true) Color(0xFF8FAF7C) else Color(0xFFF1EEF2),
                contentColor =
                    if (ui.todayStatus == true) Color.White else Color(0xFF4A4452),
                leading = if (ui.todayStatus == true) "✓" else ""
            )

            PillButton(
                text = "No",
                onClick = { if (ui.todayStatus == false) vm.clearToday()
                else vm.markToday(false) },
                containerColor =
                    if (ui.todayStatus == false) Color(0xFFE0A0A0) else Color(0xFFF1EEF2),
                contentColor =
                    if (ui.todayStatus == false) Color.White else Color(0xFF4A4452),
                leading = if (ui.todayStatus == false) "✕" else ""
            )
        }
    }
}