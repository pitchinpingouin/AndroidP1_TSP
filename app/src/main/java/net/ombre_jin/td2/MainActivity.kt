package net.ombre_jin.td2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import layout.Task
import net.ombre_jin.td2.TaskViewModel.tasks

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val taskFormIntent = Intent(this, TaskFormActivity::class.java)


        val newTask = intent.getParcelableExtra<Task>("newTask")

        if(newTask != null)
            if(newTask.id >= tasks.size){
                tasks.add(newTask)
            }

        val button = findViewById<FloatingActionButton>(R.id.floating_action_button)
        button.setOnClickListener {
            startActivity(taskFormIntent)
        }

    }
}
