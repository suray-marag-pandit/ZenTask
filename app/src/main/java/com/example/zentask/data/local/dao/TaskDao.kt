package com.example.zentask.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.zentask.data.local.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Delete
    suspend fun deleteTask(task: TaskEntity)

    @Update
    suspend fun updateTask(task: TaskEntity)

    @Query("SELECT * FROM tasks WHERE isArchived = 0 ORDER BY dueDate ASC")
    suspend fun getAllActiveTask(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE isArchived = 1 ORDER BY dueDate ASC")
    suspend fun getAllArchivedTask(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE id =:id")
    suspend fun getTaskById(id:Int):TaskEntity

}