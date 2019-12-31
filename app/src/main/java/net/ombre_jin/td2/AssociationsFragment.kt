package net.ombre_jin.td2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.tasks_fragment.view.*
import net.ombre_jin.td2.DBViewModel.associations

class AssociationsFragment : Fragment() {

    //private val coroutineScope = MainScope()
    //private val associations = mutableListOf<Association>()
    private val taskAdapter = AssociationsAdapter(associations)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = taskAdapter
        val view = inflater.inflate(R.layout.tasks_fragment, container, false)
        view.associations_recycler_view.adapter = adapter
        view.associations_recycler_view.layoutManager = LinearLayoutManager(context)
        return view
    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {

        super.onResume()
    }

    override fun onDestroy() {
        //coroutineScope.cancel()
        super.onDestroy()
    } */
}