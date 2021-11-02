package com.example.todolist.fragments

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.icu.text.CaseMap
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.database.ToDoModel
import com.example.todolist.viewmodel.ToDoViewModel


class ToDoDetailsFragment : Fragment() {


    private val toDoViewModel: ToDoViewModel by activityViewModels()
    private  lateinit var selectedTodo: ToDoModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleTextView: EditText = view.findViewById(R.id.titleD_edittext)
        val descriptionTextView: EditText = view.findViewById(R.id.descriptionD_edittext)
        val creationDateTextView: EditText = view.findViewById(R.id.creationdateD_edittext)
        val dueDate: EditText = view.findViewById(R.id.duedateD_edittext)

        val deleteButton: Button = view.findViewById(R.id.delete_button)
        val updateButton: Button = view.findViewById((R.id.update_button))


        toDoViewModel.selectedItemMutableLiveData.observe(viewLifecycleOwner, Observer {

            it?.let { todo ->
                titleTextView.setText(todo.title)
                descriptionTextView.setText(todo.description)
                creationDateTextView.setText(todo.creationtDate)
                dueDate.setText(todo.dueDate)
                selectedTodo = todo
            }


        })


        deleteButton.setOnClickListener {


            toDoViewModel.deleteToDo(selectedTodo)
            findNavController().popBackStack()
        }



        val datePicker = DatePickerDialog(requireActivity(), R.style.DialogTheme)
        datePicker.setTitle("DUE DATE")


        datePicker.setButton(DialogInterface.BUTTON_POSITIVE,"OK"){ D, I ->



            var day = datePicker.datePicker.dayOfMonth
            var month =datePicker.datePicker.month
            var year = datePicker.datePicker.year



            dueDate.setText("$day/${month+1}/$year")

        }


        dueDate.setOnClickListener {
            datePicker.show()
        }

        updateButton.setOnClickListener {

            selectedTodo.title = titleTextView.text.toString()
            selectedTodo.description = descriptionTextView.text.toString()
            selectedTodo.dueDate = dueDate.text.toString()
            selectedTodo.creationtDate = creationDateTextView.text.toString()

            toDoViewModel.updateTodoList(selectedTodo)
            findNavController().popBackStack()
        }












    }
}