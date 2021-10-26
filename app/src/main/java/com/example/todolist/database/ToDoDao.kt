package com.example.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {

    @Insert
    suspend fun addToDo(toDoModel: ToDoModel)


    @Query("SELECT * FROM todomodel")
    fun getToDo(): LiveData<List<ToDoModel>>

    @Update
    suspend fun updateToDoList(toDoModel: ToDoModel)

    @Delete

    suspend fun deleteToDo(toDoModel: ToDoModel)
}