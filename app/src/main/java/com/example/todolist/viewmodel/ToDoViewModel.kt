package com.example.todolist.viewmodel

import androidx.lifecycle.*
import com.example.todolist.database.ToDoModel
import com.example.todolist.repositories.ToDoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ToDoViewModel: ViewModel() {



    //getting the repository
   private val toDoRepository = ToDoRepository.get()




    val sortOrder = MutableStateFlow(SortOrder.BY_DATE)
    var todoitems = toDoRepository.getToDo()
    fun getSearchItems(query: String) = toDoRepository.getSearchItems(query)
    var selectedItemMutableLiveData = MutableLiveData<ToDoModel>()



    fun addToDo(title: String, due: String,isDone: Boolean, description: String) {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date())

        viewModelScope.launch {

            toDoRepository.addToDo(ToDoModel(title,due,currentDate,isDone,description))

        }

    }
    fun updateTodoList(toDoModel: ToDoModel) = viewModelScope.launch { toDoRepository.updateToDoList(toDoModel) }
    fun deleteToDo(toDoModel: ToDoModel) = viewModelScope.launch { toDoRepository.deleteToDo(toDoModel) }
    fun deleteCompletedTask() = viewModelScope.launch { toDoRepository.deleteCompletedTask() }
    fun getHideCompletedTasks(isHide: Boolean) = toDoRepository.getItems(isHide)
    }


// an enum class for the constants
enum class SortOrder{ BY_NAME, BY_DATE
}