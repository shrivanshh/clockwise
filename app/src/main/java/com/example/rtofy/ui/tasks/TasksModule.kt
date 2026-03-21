package com.example.rtofy.ui.tasks

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.rtofy.ui.common.ModuleCard
@Composable
fun TasksModule(vm: TaskViewModel) {
    ModuleCard {
        Text(
            text = "Tasks (Coming Soon)",
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = "Important: 0",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Due today: 0",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}