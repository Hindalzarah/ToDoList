package com.example.todolist.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.todolist.database.ToDoModel
import com.example.todolist.repositories.ToDoRepository

class ToDoViewModel {

    // the viewmodel has a connection with the repository so the first thing that we do is calling the repository

   private val toDoRepository = ToDoRepository.get()

    // viewmodel holds the data so now we have to call the data

    // variable for the data that we're going to call

    var getToDo = toDoRepository.getToDo()

    var selectedItemMutableLiveData = MutableLiveData<ToDoModel>()





}