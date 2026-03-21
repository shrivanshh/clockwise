package com.example.rtofy.ui.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rtofy.ui.rto.RtoModule
import com.example.rtofy.ui.rto.RtoViewModel
import com.example.rtofy.ui.tasks.TaskViewModel
import com.example.rtofy.ui.tasks.TasksModule

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(vm: RtoViewModel, tvm: TaskViewModel) {
    val modules = listOf(
        DashboardModule.Rto,
        DashboardModule.Tasks
    )

    Surface(
        modifier = Modifier.Companion.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            modifier = Modifier.Companion
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(modules, key = { it.id }) { module ->
                when (module) {
                    DashboardModule.Rto -> RtoModule(vm)
                    DashboardModule.Tasks -> TasksModule(tvm)
                }
            }
        }
    }
}