package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val todoItems = mutableListOf<TodoItem>()
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.rvTodoItems)
        recyclerView.layoutManager = LinearLayoutManager(this)
        todoAdapter = TodoAdapter(todoItems)
        recyclerView.adapter = todoAdapter

        // Initialize UI elements
        val etTodoTitle: TextInputEditText = findViewById(R.id.etTodoTitle)
        val btnAddTodo: MaterialButton = findViewById(R.id.btnAddTodo)

        // Set click listener for the "Add Todo" button
        btnAddTodo.setOnClickListener {
            val title = etTodoTitle.text.toString().trim()
            if (title.isNotEmpty()) {
                // Add a new todo item to the list
                todoItems.add(TodoItem(title))
                todoAdapter.notifyDataSetChanged()

                // Clear the input field
                etTodoTitle.text = null
            }
        }
    }
}
