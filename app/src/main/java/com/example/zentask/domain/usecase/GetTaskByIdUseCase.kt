package com.example.zentask.domain.usecase

import com.example.zentask.data.local.model.TaskEntity
import com.example.zentask.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTaskByIdUseCase (
    private val repository: TaskRepository
){
    suspend operator fun invoke(id: Int): TaskEntity {
        return repository.getTaskById(id)
    }

}