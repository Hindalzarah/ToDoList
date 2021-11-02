package com.example.todolist.fragments

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.adapter.ToDosAdapter
import com.example.todolist.database.ToDoModel
import com.example.todolist.util.onQueryTextChanged
import com.example.todolist.viewmodel.SortOrder

import com.example.todolist.viewmodel.ToDoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DisplayToDosFragment : Fragment() {



 private val todosList = mutableListOf<ToDoModel>()
    private val toDoViewModel: ToDoViewModel by activityViewModels()
    private lateinit var toDoAcapter: ToDosAdapter




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

        toDoAcapter = ToDosAdapter(todosList,toDoViewModel)

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


        setHasOptionsMenu(true)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_fragment_tasks, menu)
        // finding search menu
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView
        searchView.onQueryTextChanged {
            fetchDate(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_sort_by_name -> {
                toDoViewModel.sortOrder.value = SortOrder.BY_NAME

                todosList.sortByDescending {
                    it.title
                }
                toDoAcapter.notifyDataSetChanged()

                true
            }
            R.id.action_sort_by_date_created ->   {
                toDoViewModel.sortOrder.value = SortOrder.BY_DATE
                todosList.sortBy {
                    it.dueDate
                }
                toDoAcapter.notifyDataSetChanged()


                true


            } R.id.action_hide_completed_tasks ->{
                item.isChecked = !item.isChecked

                toDoViewModel.getHideCompletedTasks(item.isChecked).observe(viewLifecycleOwner ,{
                     if(item.isChecked) {
                    todosList.clear()
                    todosList.addAll(it)
                    toDoAcapter.notifyDataSetChanged() } else {

                        fetchDate("")
                     }

                } )
                true
            }
            R.id.action_delete_all_completed_tasks ->{
                toDoViewModel.deleteCompletedTask()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun fetchDate(query: String) {
        toDoViewModel.getSearchItems(query).observe(viewLifecycleOwner, {

            todosList.clear()
            todosList.addAll(it)
            toDoAcapter.notifyDataSetChanged()
        })
    }


    }





