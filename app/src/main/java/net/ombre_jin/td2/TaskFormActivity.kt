package net.ombre_jin.td2
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import layout.Task
import net.ombre_jin.td2.TaskViewModel.tasks

class TaskFormActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_form)
        val button = findViewById<Button>(R.id.back)
        button.setOnClickListener{
            val createActivityIntent : Intent = Intent(this, MainActivity::class.java)
            val title = findViewById<EditText>(R.id.title).text.toString()
            val description = findViewById<EditText>(R.id.description).text.toString()
            createActivityIntent.putExtra("newTask", Task( tasks.size ,title, description))
            startActivity(createActivityIntent)
        }
    }
}
