package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.database.ToDoModel
import java.util.*

class ToDosAdapter(val todos: List<ToDoModel>): RecyclerView.Adapter<ToDosAdapter.ToDosViewHolder>() {



    class ToDosViewHolder(view: View): RecyclerView.ViewHolder(view){

        val title: TextView = view.findViewById(R.id.title_textview)
        val date:TextView = view.findViewById(R.id.date_textview)
        val doneCheckBox: CheckBox = view.findViewById(R.id.done_checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDosViewHolder {

        return ToDosViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.todos_layout,
                parent,
                false)    )

    }

    override fun onBindViewHolder(holder: ToDosViewHolder, position: Int) {

        var todo = todos[position]

        holder.title.text = todo.title
        holder.date.text= todo.date.toString()
        holder.doneCheckBox.isChecked = todo.isDone



    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}