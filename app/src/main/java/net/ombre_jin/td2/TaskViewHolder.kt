package net.ombre_jin.td2

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*
import layout.Task

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(task: Task) {
        itemView.task_title.text = task.title
        itemView.task_description.text = task.description
    }
}