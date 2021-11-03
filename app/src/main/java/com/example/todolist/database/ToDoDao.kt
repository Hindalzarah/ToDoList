package com.example.todolist.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Insert
    suspend fun addToDo(toDoModel: ToDoModel)
    @Update
    suspend fun updateToDoList(toDoModel: ToDoModel)
    @Delete
    suspend fun deleteToDo(toDoModel: ToDoModel)




    /**ActionBar functions **/

    // QUERIES

    // the function that will get data from the database
    @Query("SELECT * FROM todomodel ")
    fun getToDo(): LiveData<List<ToDoModel>>

    // the function that will select specific data from the database
    @Query("SELECT * FROM ToDoModel WHERE title LIKE '%' || :searchQuery || '%' ORDER BY dueDate DESC")
    fun getSearchItems(searchQuery: String):LiveData<List<ToDoModel>>

    //the function that will hide completed todos
    @Query("SELECT * FROM ToDoModel WHERE isDone != :isHide")
    fun getHideCompletedTasks(isHide: Boolean): LiveData<List<ToDoModel>>
    //the function that will delete completed todos
    @Query("DELETE FROM ToDoModel WHERE isDone")
    suspend fun deleteCompletedTask()

}