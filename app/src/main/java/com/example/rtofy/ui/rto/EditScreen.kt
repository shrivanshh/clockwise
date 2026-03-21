package com.example.rtofy.ui.rto

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rtofy.ui.rto.RtoViewModel
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditScreen(vm: RtoViewModel) {
    val ui by vm.ui.collectAsState()
    val fmt = DateTimeFormatter.ISO_LOCAL_DATE

    LazyColumn(
        modifier = Modifier.Companion
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
                modifier = Modifier.Companion.fillMaxWidth(),
                shape = RoundedCornerShape(18.dp)
            ) {
                Row(
                    modifier = Modifier.Companion
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Companion.CenterVertically
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