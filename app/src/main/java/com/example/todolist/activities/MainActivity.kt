package com.example.todolist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.activity.viewModels
import com.example.todolist.R
import com.example.todolist.repositories.ToDoRepository
import com.example.todolist.viewmodel.ToDoViewModel

class MainActivity : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //initialization of the repository

        ToDoRepository.init(this)



} }