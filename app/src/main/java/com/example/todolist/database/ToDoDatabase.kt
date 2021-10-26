package com.example.todolist.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoModel:: class], version = 1)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun dao(): ToDoDao

}