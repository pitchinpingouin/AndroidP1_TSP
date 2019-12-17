package net.ombre_jin.td2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tasks_fragment.view.*
import net.ombre_jin.td2.TaskViewModel.tasks
import layout.Task

class TasksFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val adapter = TasksAdapter(tasks)
        //val temp =  savedInstanceState?.getParcelableArrayList<Task>("tasks") ?: tasks
        //val adapter = TasksAdapter(temp)
        val adapter = TasksAdapter(tasks)
        val view = inflater.inflate(R.layout.tasks_fragment, container, false)
        view.tasks_recycler_view.adapter = adapter
        view.tasks_recycler_view.layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
        return view
    }
   // override fun onSaveInstanceState(outState: Bundle) {
        //outState.putParcelableArrayList("tasks", tasks)
   //     super.onSaveInstanceState(outState)
    //}

}