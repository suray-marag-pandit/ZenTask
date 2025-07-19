package com.example.zentask.domain.usecase

import com.example.zentask.data.local.model.TaskEntity
import com.example.zentask.domain.repository.TaskRepository

class DeleteTaskUseCase (
    private val repository: TaskRepository
){
    suspend operator fun invoke(task: TaskEntity){
        repository.deleteTask(task)
    }

}