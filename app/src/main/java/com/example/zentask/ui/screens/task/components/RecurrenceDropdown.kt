package com.example.zentask.ui.screens.task.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.zentask.data.local.model.Recurrence

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecurrenceDropdown(
    selected: Recurrence,
    onSelected: (Recurrence) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(
            readOnly = true,
            value = selected.name,
            onValueChange = {},
            label = { Text("Recurrence") },
            modifier = Modifier.menuAnchor()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Recurrence.values().forEach { recurrence ->
                DropdownMenuItem(
                    text = { Text(recurrence.name) },
                    onClick = {
                        onSelected(recurrence)
                        expanded = false
                    }
                )
            }
        }
    }
}
