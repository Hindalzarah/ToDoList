package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.todolist.R


class AddToDoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_to_do, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // declaring variables for the fragment views

        val titleEditText: EditText = view.findViewById(R.id.title_edittext)
        val dueDateEditText: EditText = view.findViewById(R.id.dueDate_edittext)
        val detailsEditText: EditText = view.findViewById(R.id.details_edittext)
        val saveButton: Button = view.findViewById(R.id.save_button)

        saveButton.setOnClickListener {



        }

    }



}