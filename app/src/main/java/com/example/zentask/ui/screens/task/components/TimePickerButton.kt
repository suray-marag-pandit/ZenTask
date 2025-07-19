package com.example.zentask.ui.screens.task.components

import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TimePickerButton(
    label: String = "Reminder Time",
    initialTimeMillis: Long? = null,
    onTimeSelected: (Long) -> Unit
) {
    val context = LocalContext.current
    val formatter = remember { SimpleDateFormat("hh:mm a", Locale.getDefault()) }
    var displayText by remember(initialTimeMillis) {
        mutableStateOf(
            initialTimeMillis?.let { formatter.format(Date(it)) } ?: "Not set"
        )
    }

    TextButton(
        onClick = {
            showTimePicker(context, initialTimeMillis) { selectedMillis ->
                displayText = formatter.format(Date(selectedMillis))
                onTimeSelected(selectedMillis)
            }
        }
    ) {
        Text("$label: $displayText")
    }
}

private fun showTimePicker(
    context: Context,
    initialMillis: Long?,
    onTimeSelected: (Long) -> Unit
) {
    val calendar = Calendar.getInstance()
    initialMillis?.let { calendar.timeInMillis = it }

    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    TimePickerDialog(
        context,
        { _, selectedHour, selectedMinute ->
            calendar.set(Calendar.HOUR_OF_DAY, selectedHour)
            calendar.set(Calendar.MINUTE, selectedMinute)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            onTimeSelected(calendar.timeInMillis)
        },
        hour,
        minute,
        false
    ).show()
}
