package com.example.zentask.domain.usecase

data class TaskUseCases(
    val addTask: AddTaskUseCase,
    val deleteTask: DeleteTaskUseCase,
    val updateTask: UpdateTaskUseCase,
    val getAllActiveTasks: GetAllActiveTasksUseCase,
    val getAllArchivedTasks: GetArchivedTasksUseCase,
    val getTaskById: GetTaskByIdUseCase
)
