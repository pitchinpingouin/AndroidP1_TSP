package net.ombre_jin.td2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_task.view.*
import layout.Association


class AssociationsAdapter(private val associations: MutableList<Association>) : RecyclerView.Adapter<AssociationViewHolder>()
{
    lateinit var context : Context

    override fun getItemCount(): Int {
        return associations.size
    }
    private fun onDeleteClickListener(association: Association) {
        associations.remove(association)
        notifyDataSetChanged()
    }

    private fun onEditClickListener(association : Association) {

        val createActivityIntent = Intent(context, AssociationFormActivity::class.java)
        createActivityIntent.putExtra("AssociationToEdit", Association(association.id, association.gender, association.word1, association.word2, association.description))

        startActivity(context, createActivityIntent, null)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AssociationViewHolder, position: Int) {
        holder.bind(associations[position])

        holder.itemView.association_delete.setOnClickListener{
            onDeleteClickListener(associations[position])
        }
        holder.itemView.association_edit.setOnClickListener {
            onEditClickListener(associations[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssociationViewHolder {
        context = parent.context
        return AssociationViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false))
    }
}