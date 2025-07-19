package com.example.zentask.domain.repository

import com.example.zentask.data.local.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    suspend fun insertTask(task: TaskEntity)
    suspend fun deleteTask(task: TaskEntity)
    suspend fun updateTask(task: TaskEntity)
    suspend fun getAllActiveTask(): Flow<List<TaskEntity>>
    suspend fun getAllArchivedTask(): Flow<List<TaskEntity>>
    suspend fun getTaskById(id:Int):TaskEntity

}