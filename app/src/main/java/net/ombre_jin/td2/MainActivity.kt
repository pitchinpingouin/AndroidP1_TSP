package net.ombre_jin.td2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import layout.Task

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val taskFormIntent = Intent(this, TaskFormActivity::class.java)

        val newTask = intent.getParcelableExtra<Task>("newTask")
        if(newTask != null)
            TaskViewModel.tasks.add(newTask)

        val button = findViewById<FloatingActionButton>(R.id.floating_action_button)
        button.setOnClickListener {
            startActivity(taskFormIntent)
        }

    }


}
