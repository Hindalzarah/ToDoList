package com.example.todolist.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ToDoModel(

    var title: String,
    var dueDate: String,
    var creationtDate: String,
    var isDone: Boolean,
    var description: String,

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,


)
