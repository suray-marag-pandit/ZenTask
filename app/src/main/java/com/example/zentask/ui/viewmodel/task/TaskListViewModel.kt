package com.zenapp.zentask.ui.viewmodel.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zentask.data.local.model.TaskEntity
import com.example.zentask.domain.usecase.GetAllActiveTasksUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class TaskListViewModel(
    private val getAllActiveTasksUseCase: GetAllActiveTasksUseCase
) : ViewModel() {

    private val _tasks = MutableStateFlow<List<TaskEntity>>(emptyList())
    val tasks: StateFlow<List<TaskEntity>> = _tasks

    init {
        viewModelScope.launch {
            getAllActiveTasksUseCase().collect { list ->
                _tasks.value = list
            }
        }
    }
}
