package com.example.todolist.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ToDoModel(

    var title: String,
    var date: Date,
    var isDone: Boolean,

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,


)
