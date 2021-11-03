package com.example.todolist.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoModel:: class], version = 2)
abstract class ToDoDatabase: RoomDatabase() {

    //calling the dao

    abstract fun dao(): ToDoDao

}