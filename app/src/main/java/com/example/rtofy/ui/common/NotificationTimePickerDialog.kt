package com.example.rtofy.ui.common

import android.app.TimePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext

@Composable
fun NotificationTimePickerDialog(
    initialHour: Int,
    initialMinute: Int,
    onDismiss: () -> Unit,
    onConfirm: (Int, Int) -> Unit
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        TimePickerDialog(
            context,
            { _, hourOfDay, minute ->
                onConfirm(hourOfDay, minute)
            },
            initialHour,
            initialMinute,
            false
        ).apply {
            setOnDismissListener { onDismiss() }
        }.show()
    }
}