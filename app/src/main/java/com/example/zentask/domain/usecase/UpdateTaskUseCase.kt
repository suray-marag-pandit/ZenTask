package com.example.zentask.domain.usecase

import com.example.zentask.data.local.model.TaskEntity
import com.example.zentask.domain.repository.TaskRepository

class UpdateTaskUseCase (
    private val repository: TaskRepository
){
    suspend operator fun invoke(task: TaskEntity){
        repository.updateTask(task)
    }

}