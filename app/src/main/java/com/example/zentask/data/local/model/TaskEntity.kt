package com.example.zentask.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "tasks")
@Serializable
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int  = 0,

    val title: String, // Title or short name of the task

    val description: String, // Detailed description of the task

    val category: String, // User-defined category (e.g., Work, Personal)

    val dueDate: Long?, // Due date stored as epoch time (nullable)

    val reminderTime: Long?, // Time to notify user (nullable)

    val isArchived: Boolean = false, // Whether task is archived or not

    val isCompleted: Boolean = false, // Whether task is marked as done

    val priority: Int = 0, // 0 = Low, 1 = Medium, 2 = High

    val recurrence: Recurrence? = null, // Optional: repeats daily/weekly/etc

    val attachmentUri: String? = null, // URI to file/image/document

    val createdAt: Long = System.currentTimeMillis() // Timestamp when created

)

@Serializable
enum class Recurrence {
    DAILY,
    WEEKLY,
    MONTHLY,
    YEARLY,
    NONE
}