package net.ombre_jin.td2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tasks_fragment.view.*
import androidx.lifecycle.ViewModelProviders
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import net.ombre_jin.td2.TaskViewModel.tasks
import layout.Task

class TasksFragment : Fragment() {

    private val coroutineScope = MainScope()
    private val tasksRepository = TaskRepository()
    private val tasks = mutableListOf<Task>()
    private val taskAdapter = TasksAdapter(tasks)
    private val taskViewModel by lazy { ViewModelProviders.of(this).get(TasksViewModel::class.java)}


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = taskAdapter
        val view = inflater.inflate(R.layout.tasks_fragment, container, false)
        view.tasks_recycler_view.adapter = adapter
        view.tasks_recycler_view.layoutManager = LinearLayoutManager(context)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        // subscribe the fragment to task update

        /*tasksRepository.getTasks().observe(this, Observer{
            if( it != null){
                tasks.clear()
                tasks.addAll(it)
                Log.e("task", it.toString())
                taskAdapter.notifyDataSetChanged()
            }
        })*/

        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        coroutineScope.launch {
            API.userService.getInfo()
        }

        //taskViewModel.loadTasks(this)

        super.onResume()
    }

    override fun onDestroy() {
        coroutineScope.cancel()
        super.onDestroy()
    }
}