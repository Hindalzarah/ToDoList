package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DisplayToDosFragment : Fragment() {



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

        val addFloatingActionButton: FloatingActionButton = view.findViewById(R.id.add_floatingActionButton)


        addFloatingActionButton.setOnClickListener{




        }

    }
}