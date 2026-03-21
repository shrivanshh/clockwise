package com.example.rtofy

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rtofy.ui.home.HomeScreen
import com.example.rtofy.ui.rto.EditScreen
import com.example.rtofy.ui.rto.RtoViewModel
import com.example.rtofy.ui.rto.SettingsScreen
import com.example.rtofy.ui.tasks.TaskViewModel

enum class Dest(val route: String, val label: String) {
    Home("home", "Home"),
    Edit("edit", "Edit"),
    Settings("settings", "Settings")
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoot(vm: RtoViewModel = viewModel(), tvm: TaskViewModel = viewModel()) {
    val nav = rememberNavController()
    val backStackEntry by nav.currentBackStackEntryAsState()
    val current = backStackEntry?.destination?.route ?: Dest.Home.route

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    listOf(Dest.Home, Dest.Edit, Dest.Settings).forEach { d ->
                        NavigationBarItem(
                            selected = current == d.route,
                            onClick = {
                                nav.navigate(d.route) {
                                    popUpTo(nav.graph.findStartDestination().id) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { },
                            label = { Text(d.label) }
                        )
                    }
                }
            }
        ) { pad ->
            NavHost(
                navController = nav,
                startDestination = Dest.Home.route,
                modifier = Modifier.padding(pad)
            ) {
                composable(Dest.Home.route) { HomeScreen(vm, tvm) }
                composable(Dest.Edit.route) { EditScreen(vm) }
                composable(Dest.Settings.route) { SettingsScreen(vm) }
            }
        }
    }
}