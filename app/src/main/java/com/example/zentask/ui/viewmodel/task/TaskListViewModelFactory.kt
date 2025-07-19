package com.example.zentask.ui.viewmodel.task

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zentask.domain.usecase.GetAllActiveTasksUseCase
import com.zenapp.zentask.ui.viewmodel.task.TaskListViewModel

class TaskListViewModelFactory(
    private val getAllActiveTasksUseCase: GetAllActiveTasksUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TaskListViewModel(getAllActiveTasksUseCase) as T
    }
}
