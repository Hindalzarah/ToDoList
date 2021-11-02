package com.example.todolist.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.database.ToDoModel
import com.example.todolist.viewmodel.ToDoViewModel
import java.text.SimpleDateFormat
import java.util.*

class ToDosAdapter(val todos: List<ToDoModel>, val toDoViewModel: ToDoViewModel): RecyclerView.Adapter<ToDosAdapter.ToDosViewHolder>() {



    class ToDosViewHolder(view: View): RecyclerView.ViewHolder(view){

        val title: TextView = view.findViewById(R.id.title_textview)
        val date:TextView = view.findViewById(R.id.date_textview)
        val doneCheckBox: CheckBox = view.findViewById(R.id.done_checkBox)
        val currentDate: TextView = view.findViewById(R.id.creation_textview)
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
        holder.date.text= todo.dueDate
        holder.doneCheckBox.isChecked = todo.isDone
        holder.currentDate.text = "creation date: ${todo.creationtDate}"



        var dueDate = Date()

        val format = SimpleDateFormat("yyyy/MM/dd")
        val date = format.parse(todo.dueDate)

        if(dueDate> date)


        {


            holder.title.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            holder.date.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            holder.doneCheckBox.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG


        }

        holder.doneCheckBox.setOnClickListener {


            if (holder.doneCheckBox.isChecked ) {
                holder.title.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                holder.date.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                holder.doneCheckBox.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            } else {


                holder.title.paintFlags = 0
                holder.date.paintFlags = 0
                holder.doneCheckBox.paintFlags = 0

            }



        }


        // to open the details fragment

        holder.itemView.setOnClickListener{


            toDoViewModel.selectedItemMutableLiveData.postValue(todo)

            it.findNavController().navigate(R.id.action_displayToDosFragment_to_toDoDetailsFragment)
        }

        holder.doneCheckBox.setOnClickListener {

            todo.isDone = holder.doneCheckBox.isChecked
            toDoViewModel.updateTodoList(todo)
        }



    }

    override fun getItemCount(): Int {
      return todos.size

    }
}