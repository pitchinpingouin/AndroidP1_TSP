package net.ombre_jin.td2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.tasks_fragment.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycler_view)

        val backToMainIntent = Intent(this, MainActivity::class.java)

        back_to_main.setOnClickListener{
            startActivity(backToMainIntent)
        }
    }
}
