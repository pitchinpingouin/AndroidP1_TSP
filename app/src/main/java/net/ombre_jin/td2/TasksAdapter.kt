package net.ombre_jin.td2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import layout.Task

class TasksAdapter(private val tasks: MutableList<Task>) : RecyclerView.Adapter<TaskViewHolder>()
{
    lateinit var context : Context
    private val coroutineScope = MainScope()

    override fun getItemCount(): Int {
        return tasks.size
    }
    private fun onDeleteClickListener(task : Task) {
        //tasks.remove(task)
        //notifyDataSetChanged()
        coroutineScope.launch {
            API.taskService.deleteTask(task.id)
            tasks.remove(task)
            notifyDataSetChanged()
        }

    }

    private fun onEditClickListener(task : Task) {

        val createActivityIntent : Intent = Intent(context, TaskFormActivity::class.java)

        createActivityIntent.putExtra("taskToEdit", Task(task.id, task.title, task.description))

        startActivity(context, createActivityIntent, null)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
        holder.itemView.task_delete.setOnClickListener{
            onDeleteClickListener(tasks[position])
        }
        holder.itemView.task_edit.setOnClickListener { onEditClickListener(tasks[position])}

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        context = parent.context
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }
}