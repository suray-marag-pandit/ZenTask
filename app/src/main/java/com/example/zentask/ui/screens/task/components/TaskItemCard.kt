package com.example.zentask.ui.screens.task.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.zentask.data.local.model.TaskEntity
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TaskItemCard(
    task: TaskEntity,
    onClick: () -> Unit
) {
    val dateFormatter = remember { SimpleDateFormat("dd MMM yyyy", Locale.getDefault()) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(text = task.title, style = MaterialTheme.typography.titleMedium)

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = task.dueDate?.let { "Due: ${dateFormatter.format(Date(it))}" } ?: "No Due Date",
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = "Priority: ${priorityLabel(task.priority)}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

private fun priorityLabel(priority: Int): String {
    return when (priority) {
        0 -> "Low"
        1 -> "Medium"
        2 -> "High"
        else -> "Unknown"
    }
}
