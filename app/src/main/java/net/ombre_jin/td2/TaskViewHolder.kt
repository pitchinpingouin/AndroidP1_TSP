package net.ombre_jin.td2

import android.text.Editable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_association_form.view.*
import layout.Association

class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(association: Association) {
        itemView.gender_title.text = association.gender
        itemView.association.text = association.word1 + " - " + association.word2
        //itemView.description.text = association.description
    }
}