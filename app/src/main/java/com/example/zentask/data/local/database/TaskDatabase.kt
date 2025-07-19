package com.example.zentask.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.zentask.data.local.converter.RecurrenceConverter
import com.example.zentask.data.local.dao.TaskDao
import com.example.zentask.data.local.model.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(RecurrenceConverter::class)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}