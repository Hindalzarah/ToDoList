package com.example.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Insert
    suspend fun addToDo(toDoModel: ToDoModel)


    @Query("SELECT * FROM todomodel ")
    fun getToDo(): LiveData<List<ToDoModel>>

//    @Query("SELECT * FROM todomodel WHERE title LIKE :searchQuery ")
//    fun searchDatabase(searchQuery: String): Flow<List<ToDoModel>>

    @Query("SELECT * FROM ToDoModel WHERE title LIKE '%' || :searchQuery || '%' ORDER BY dueDate DESC")
    fun getSearchItems(searchQuery: String):LiveData<List<ToDoModel>>

    @Query("SELECT * FROM ToDoModel WHERE isDone != :isHide")
    fun getHideCompletedTasks(isHide: Boolean): LiveData<List<ToDoModel>>


    @Query("DELETE FROM ToDoModel WHERE isDone")
    suspend fun deleteCompletedTask()


    @Update
    suspend fun updateToDoList(toDoModel: ToDoModel)

    @Delete

    suspend fun deleteToDo(toDoModel: ToDoModel)
}