package com.example.todolist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.database.ToDoModel
import com.example.todolist.repositories.ToDoRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ToDoViewModel: ViewModel() {

    // the viewmodel has a connection with the repository so the first thing that we do is calling the repository

   private val toDoRepository = ToDoRepository.get()

    // viewmodel holds the data so now we have to call the datay

    // variable for the data that we're going to call

    var todoitems = toDoRepository.getToDo()

    var selectedItemMutableLiveData = MutableLiveData<ToDoModel>()



    fun addToDo(title: String, due: String,isDone: Boolean, description: String) {
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        viewModelScope.launch {

            toDoRepository.addToDo(ToDoModel(title,due,currentDate,isDone,description))

        }

    }

    fun updateTodoList(toDoModel: ToDoModel) = viewModelScope.launch { toDoRepository.updateToDoList(toDoModel) }


    fun deleteToDo(toDoModel: ToDoModel) = viewModelScope.launch { toDoRepository.deleteToDo(toDoModel) }

}