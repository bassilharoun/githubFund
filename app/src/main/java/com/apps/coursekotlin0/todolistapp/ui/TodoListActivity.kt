package com.apps.coursekotlin0.todolistapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.coursekotlin0.R
import com.apps.coursekotlin0.databinding.ActivityTodoListBinding
import com.apps.coursekotlin0.todolistapp.model.Todo
import com.apps.coursekotlin0.todolistapp.utils.TodoAdapter

class TodoListActivity : Fragment() {
    private lateinit var binding: ActivityTodoListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityTodoListBinding.inflate(inflater,container,false)
        val view = binding.root
        val todoListSingleItem = mutableListOf(Todo("learn kotlin" , false))

        val adapter = TodoAdapter(todoListSingleItem)

        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(activity)


        binding.btnAddTodo.setOnClickListener{

            val newTodoTitle = binding.etAddTodo.text.toString()
            val newTodo = Todo(newTodoTitle,false)
            todoListSingleItem.add(newTodo)
            adapter.notifyDataSetChanged()
            binding.etAddTodo.text.clear()
        }
        return view
    }


}