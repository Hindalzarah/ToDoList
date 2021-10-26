package com.example.todolist.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R

class ToDosAdapter(): RecyclerView.Adapter<ToDosAdapter.ToDosViewHolder>() {



    class ToDosViewHolder(view: View): RecyclerView.ViewHolder(view){

        val title: TextView = view.findViewById(R.id.title_textview)
        val date: TextView = view.findViewById(R.id.date_textview)
        val doneCheckBox: CheckBox = view.findViewById(R.id.done_checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDosViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ToDosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}