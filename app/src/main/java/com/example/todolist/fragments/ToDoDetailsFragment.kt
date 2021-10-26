package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.todolist.R


class ToDoDetailsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val titleDTextView: TextView = view.findViewById(R.id.titleD_textView)
         val detailsTextView: TextView = view.findViewById(R.id.details_textView)
        val editButton: Button = view.findViewById(R.id.edit_button)
        val deleteButton: Button = view.findViewById(R.id.delete_button)


        editButton.setOnClickListener {

        }

        deleteButton.setOnClickListener {


        }



    }
}