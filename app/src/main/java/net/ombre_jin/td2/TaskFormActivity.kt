package net.ombre_jin.td2
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import layout.Task
import net.ombre_jin.td2.TaskViewModel.tasks

class TaskFormActivity : AppCompatActivity() {

    private val coroutineScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_form)
        val createActivityIntent : Intent = Intent(this, MainActivity::class.java)

        var taskReceived = intent.getParcelableExtra<Task>("taskToEdit")

        val button = findViewById<Button>(R.id.back)
        var title = findViewById<EditText>(R.id.title)
        var description = findViewById<EditText>(R.id.description)


        if(taskReceived != null){
            title.setText(taskReceived.title)
            description.setText(taskReceived.description)
        }

        button.setOnClickListener{

            if(title.text.toString() != ""){
                if(taskReceived != null){
                /*    if (taskReceived.id - 1 < tasks.size) {
                        tasks[taskReceived.id - 1].title = title.text.toString()
                        tasks[taskReceived.id - 1].description = description.text.toString()
                    }*/
                }
                else{
                    //createActivityIntent.putExtra("newTask", Task(tasks.size, title.text.toString(), description.text.toString()))
                    //tasks.add( Task(tasks.size, title.text.toString(), description.text.toString()))

                    coroutineScope.launch {
                        API.INSTANCE.taskService.createTask(Task(/*tasks.size*/title.text.toString(), title.text.toString(), description.text.toString()))
                    }
                }
            }
            startActivity(createActivityIntent)
        }
    }
}
