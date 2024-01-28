// TodoAdapter.kt
package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val todoItems: List<TodoItem>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTodoTitle: TextView = itemView.findViewById(R.id.tvTodoTitle)
        val cbDone: CheckBox = itemView.findViewById(R.id.cbDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ViewHolder(view)
    }
1
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val todoItem = todoItems[position]

        // Bind data to views
        holder.tvTodoTitle.text = todoItem.title
        holder.cbDone.isChecked = todoItem.isDone

        // Set click listener for checkbox
        holder.cbDone.setOnClickListener {
            todoItem.isDone = holder.cbDone.isChecked
        }
    }

    override fun getItemCount(): Int {
        return todoItems.size
    }
}
