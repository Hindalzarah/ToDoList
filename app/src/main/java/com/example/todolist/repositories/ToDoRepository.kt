package com.example.todolist.repositories

import android.content.Context
import androidx.room.Room
import com.example.todolist.database.ToDoDatabase
import com.example.todolist.database.ToDoModel
import com.example.todolist.viewmodel.ToDoViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import org.intellij.lang.annotations.Flow
import java.lang.Exception

private const val DATABASE_NAME = "ToDo-database"
class ToDoRepository(context: Context) {


    // building of the database
    private val database: ToDoDatabase = Room.databaseBuilder(context,
        ToDoDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration().build()



// calling the dao
    val toDoDao = database.dao()


    val searchQuery = MutableStateFlow("")


// getting the functions from the dao
    fun getToDo() = toDoDao.getToDo()


    suspend fun addToDo(toDoModel: ToDoModel) = toDoDao.addToDo(toDoModel)
    suspend fun updateToDoList(toDoModel: ToDoModel) = toDoDao.updateToDoList(toDoModel)
    suspend fun deleteToDo(toDoModel: ToDoModel) = toDoDao.deleteToDo(toDoModel)

    fun getItems(isHide: Boolean) = toDoDao.getHideCompletedTasks(isHide)
    fun getSearchItems(query: String) = toDoDao.getSearchItems(query)
    suspend fun deleteCompletedTask() = toDoDao.deleteCompletedTask()


// companion object of the repository to first initialize it and then getting it to the viewModel.

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

