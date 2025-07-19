package com.example.zentask.ui.viewmodel.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zentask.data.local.model.TaskEntity
import com.example.zentask.domain.usecase.AddTaskUseCase
import kotlinx.coroutines.launch

class AddTaskViewModel (
    private val addTaskUseCase: AddTaskUseCase
): ViewModel(){
    fun addTask(task: TaskEntity, onComplete: () -> Unit) {
        viewModelScope.launch {
            addTaskUseCase(task)
            onComplete()
        }
    }
}