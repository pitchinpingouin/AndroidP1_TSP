package net.ombre_jin.td2

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import layout.Task
import net.ombre_jin.td2.TaskRepository

class TasksViewModel : ViewModel(){
    private val repository = TaskRepository()
    private var tasks = mutableListOf<Task>()
    val tasksAdapter = TasksAdapter(tasks)

    fun loadTasks(lifecycle: LifecycleOwner) {
        repository.getTasks().observe(
            lifecycle,
            Observer {
                if(it==null)return@Observer
                tasks.clear()
                tasks.addAll(it)
                tasksAdapter.notifyDataSetChanged()
            })
    }
}
