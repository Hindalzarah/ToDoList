package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.viewmodel.ToDoViewModel


class AddToDoFragment : Fragment() {

    private val toDoViewModel: ToDoViewModel by activityViewModels()

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
        val descriptionEditText: EditText = view.findViewById(R.id.description_edittext)
        val saveButton: Button = view.findViewById(R.id.save_button)

        saveButton.setOnClickListener {


            var title = titleEditText.text.toString()
            var dueDate = dueDateEditText.text.toString()
            var description = descriptionEditText.text.toString()

            if (title.isNotEmpty() && dueDate.isNotEmpty() && description.isNotEmpty())
                toDoViewModel.addToDo(title,dueDate,false,description)


            findNavController().popBackStack()


            Toast.makeText(requireContext(), "Todo Successfully Added! :)", Toast.LENGTH_LONG).show()
        }

    }



}