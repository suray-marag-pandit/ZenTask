package com.example.zentask.ui.screens.task.components

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun DatePickerButton(
    label: String = "Due Date",
    initialDateMillis: Long? = null,
    onDateSelected: (Long) -> Unit
) {
    val context = LocalContext.current
    val formatter = remember { SimpleDateFormat("dd MMM yyyy", Locale.getDefault()) }
    var displayText by remember(initialDateMillis) {
        mutableStateOf(
            initialDateMillis?.let { formatter.format(Date(it)) } ?: "Not set"
        )
    }

    TextButton(
        onClick = {
            showDatePicker(context, initialDateMillis) { selectedMillis ->
                displayText = formatter.format(Date(selectedMillis))
                onDateSelected(selectedMillis)
            }
        }
    ) {
        Text("$label: $displayText")
    }
}

private fun showDatePicker(
    context: Context,
    initialMillis: Long?,
    onDateSelected: (Long) -> Unit
) {
    val calendar = Calendar.getInstance()
    initialMillis?.let { calendar.timeInMillis = it }

    DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            onDateSelected(calendar.timeInMillis)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).show()
}
