package com.example.todolist.fragments

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.viewmodel.ToDoViewModel


class AddToDoFragment : Fragment(){

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

        val datePicker = DatePickerDialog(requireActivity(), R.style.DialogTheme)
        datePicker.setTitle("DUE DATE")


        datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"OK"){ D, I ->



            var day = datePicker.datePicker.dayOfMonth
            var month =datePicker.datePicker.month
            var year = datePicker.datePicker.year



            dueDateEditText.setText("$day/${month+1}/$year")

        }


        dueDateEditText.setOnClickListener {
            datePicker.show()
        }


        saveButton.setOnClickListener {

            var title = titleEditText.text.toString()
            var description = descriptionEditText.text.toString()
            var duedate = dueDateEditText.text.toString()

            if (title.isNotEmpty() && duedate.isNotEmpty() && description.isNotEmpty())
                toDoViewModel.addToDo(title,duedate,false,description)


            findNavController().popBackStack()


            Toast.makeText(requireContext(), "Todo Successfully Added! :)", Toast.LENGTH_LONG).show()
        }

    }



}