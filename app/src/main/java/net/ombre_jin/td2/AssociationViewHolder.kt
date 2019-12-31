package net.ombre_jin.td2

import android.text.Editable
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_association_form.view.*
import kotlinx.android.synthetic.main.item_task.view.*
import layout.Association

class AssociationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(association: Association) {
        itemView.association_gender.text = association.gender
        itemView.association_words.text = association.word1 + " - " + association.word2
    }
}