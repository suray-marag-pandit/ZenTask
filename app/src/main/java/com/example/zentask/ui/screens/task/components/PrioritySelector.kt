package com.example.zentask.ui.screens.task.components
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun PrioritySelector(
    selected: Int,
    onSelected: (Int) -> Unit
) {
    val options = listOf("Low", "Medium", "High")

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Priority")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            options.forEachIndexed { index, label ->
                FilterChip(
                    selected = selected == index,
                    onClick = { onSelected(index) },
                    label = { Text(label) }
                )
            }
        }
    }
}
