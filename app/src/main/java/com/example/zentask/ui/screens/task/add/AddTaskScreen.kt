package com.zenapp.zentask.ui.screens.task.add

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.zentask.data.local.model.Recurrence
import com.example.zentask.data.local.model.TaskEntity
import com.example.zentask.ui.screens.task.components.DatePickerButton
import com.example.zentask.ui.screens.task.components.PrioritySelector
import com.example.zentask.ui.screens.task.components.RecurrenceDropdown
import com.example.zentask.ui.screens.task.components.TimePickerButton
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(
    onBack: () -> Unit,
    onTaskSaved: () -> Unit,
    addTask: (TaskEntity) -> Unit
) {
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var dueDateMillis by remember { mutableStateOf<Long?>(null) }
    var reminderTimeMillis by remember { mutableStateOf<Long?>(null) }
    var priority by remember { mutableStateOf(0) }
    var recurrence by remember { mutableStateOf(Recurrence.NONE) }

    // Format date/time for display
    val dateFormatter = remember { SimpleDateFormat("dd MMM yyyy", Locale.getDefault()) }
    val timeFormatter = remember { SimpleDateFormat("hh:mm a", Locale.getDefault()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Task") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            if (title.isBlank()) {
                                Toast.makeText(context, "Title is required", Toast.LENGTH_SHORT).show()
                                return@IconButton
                            }
                            val task = TaskEntity(
                                title = title.trim(),
                                description = description.trim(),
                                category = category.trim(),
                                dueDate = dueDateMillis,
                                reminderTime = reminderTimeMillis,
                                priority = priority,
                                recurrence = recurrence,
                                isArchived = false,
                                isCompleted = false,
                                attachmentUri = null // Placeholder
                            )
                            addTask(task)
                            onTaskSaved()
                        },
                        enabled = title.isNotBlank()
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Save")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title *") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                label = { Text("Category") },
                modifier = Modifier.fillMaxWidth()
            )

            // Due Date Picker
            DatePickerButton(
                label = "Due Date",
                initialDateMillis = dueDateMillis,
                onDateSelected = { dueDateMillis = it }
            )

            // Reminder Time Picker
            TimePickerButton(
                label = "Reminder Time",
                initialTimeMillis = reminderTimeMillis,
                onTimeSelected = { reminderTimeMillis = it }
            )

            PrioritySelector(priority) { selected -> priority = selected }

            RecurrenceDropdown(
                selected = recurrence,
                onSelected = { recurrence = it }
            )
        }
    }
}
