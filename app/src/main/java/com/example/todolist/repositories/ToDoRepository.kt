package com.example.todolist.repositories

import android.content.Context
import androidx.room.Room
import com.example.todolist.database.ToDoDatabase
import com.example.todolist.database.ToDoModel
import java.lang.Exception

private const val DATABASE_NAME = "ToDo-database"
class ToDoRepository(context: Context) {


    private val database: ToDoDatabase = Room.databaseBuilder(context,
        ToDoDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration().build()


    val toDoDao = database.dao()


    fun getToDo() = toDoDao.getToDo()
    suspend fun addToDo(toDoModel: ToDoModel) = toDoDao.addToDo(toDoModel)
    suspend fun updateToDoList(toDoModel: ToDoModel) = toDoDao.updateToDoList(toDoModel)
    suspend fun DeleteToDo(toDoModel: ToDoModel) = toDoDao.deleteToDo(toDoModel)


    companion object {

        private var toDoRepositoryInstance: ToDoRepository? = null

        // create a function of the repository
        //assign instance

        fun init(context: Context) {

            if (toDoRepositoryInstance == null)
                toDoRepositoryInstance = ToDoRepository(context)


        }

        // get the instance
        fun get(): ToDoRepository {

            return toDoRepositoryInstance ?: throw Exception("Repository Must Be Initialized")


        }

    }
}
