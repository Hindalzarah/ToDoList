package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.adapter.ToDosAdapter
import com.example.todolist.database.ToDoModel
import com.example.todolist.viewmodel.ToDoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DisplayToDosFragment : Fragment() {



 private val todosList = mutableListOf<ToDoModel>()
    private val toDoViewModel: ToDoViewModel by activityViewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_to_dos, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // initialization of the recyclerview
        val todoRecyclerView: RecyclerView = view.findViewById(R.id.todos_recyclerview)

        val toDoAcapter = ToDosAdapter(todosList,toDoViewModel)

        todoRecyclerView.adapter = toDoAcapter

        toDoViewModel.todoitems.observe(viewLifecycleOwner, Observer {

            it?.let { todos ->

                todosList.clear()
                todosList.addAll(todos)

                toDoAcapter.notifyDataSetChanged()
            }

        })



        val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.add_floatingbutton)


        addFloatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_displayToDosFragment_to_addToDoFragment)
        }

    }
}