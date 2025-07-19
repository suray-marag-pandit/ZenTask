package com.example.zentask.domain.repository

import com.example.zentask.data.local.dao.TaskDao
import com.example.zentask.data.local.model.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val taskDao: TaskDao

):TaskRepository {
    override suspend fun insertTask(task: TaskEntity) {
        taskDao.insertTask(task)
    }

    override suspend fun deleteTask(task: TaskEntity) {
        taskDao.deleteTask(task)
    }

    override suspend fun updateTask(task: TaskEntity) {
        taskDao.updateTask(task)
    }

    override suspend fun getAllActiveTask(): Flow<List<TaskEntity>> {
        return taskDao.getAllActiveTask()
    }

    override suspend fun getAllArchivedTask(): Flow<List<TaskEntity>> {
        return taskDao.getAllActiveTask()
    }

    override suspend fun getTaskById(id: Int): TaskEntity {
        return taskDao.getTaskById(id)
    }

}