package com.example.rtofy.ui
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { RtoApp() }
    }
}

enum class Dest(val route: String, val label: String) { Home("home","Home"), Edit("edit","Edit"), Settings("settings","Settings") }

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RtoApp(vm: RtoViewModel = viewModel()) {
    val nav = rememberNavController()
    val backStackEntry by nav.currentBackStackEntryAsState()
    val current = backStackEntry?.destination?.route ?: Dest.Home.route

    Scaffold(
        topBar = { TopAppBar(title = { Text("Return To Office Tracker (FY)") }) },
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
                        icon = { }, label = { Text(d.label) }
                    )
                }
            }
        }
    ) { pad ->
        NavHost(navController = nav, startDestination = Dest.Home.route, modifier = Modifier.padding(pad)) {
            composable(Dest.Home.route) { HomeScreen(vm) }
            composable(Dest.Edit.route) { EditScreen(vm) }
            composable(Dest.Settings.route) { SettingsScreen(vm) }
        }
    }
}
