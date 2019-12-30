package net.ombre_jin.td2

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*
import layout.Word

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(word: Word) {
        itemView.task_title.text = word.word
        itemView.task_description.text = word.description
    }
}