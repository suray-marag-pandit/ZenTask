package com.example.zentask.ui.screens.task.list

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zentask.domain.usecase.GetAllActiveTasksUseCase
import com.example.zentask.ui.viewmodel.task.TaskListViewModelFactory
import com.zenapp.zentask.ui.viewmodel.task.TaskListViewModel


@Composable
fun TaskListScreenRoot(
    getAllActiveTasksUseCase: GetAllActiveTasksUseCase,
    onAddClick: () -> Unit
) {
    val viewModel: TaskListViewModel = viewModel(
        factory = TaskListViewModelFactory(getAllActiveTasksUseCase)
    )

    TaskListScreen(viewModel = viewModel, onAddClick = onAddClick)
}
