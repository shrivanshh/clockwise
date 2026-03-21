package com.example.rtofy.ui.home

sealed class DashboardModule(val id: String) {
    data object Rto : DashboardModule("rto")
    data object Tasks : DashboardModule("tasks")
}