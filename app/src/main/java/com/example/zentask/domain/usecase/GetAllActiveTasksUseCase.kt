package com.example.zentask.domain.usecase

import com.example.zentask.data.local.model.TaskEntity
import com.example.zentask.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetAllActiveTasksUseCase (
    private val repository: TaskRepository
){
    suspend operator fun invoke(): Flow<List<TaskEntity>>{
        return repository.getAllActiveTask()
    }

}