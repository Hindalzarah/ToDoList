package com.example.todolist.util


import android.view.accessibility.AccessibilityManager
import android.widget.SearchView

inline fun SearchView.onQueryTextChanged(crossinline listener:(String) -> Unit) {
    this.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            listener(newText.orEmpty())
            return true
        }

    })
}