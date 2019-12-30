package net.ombre_jin.td2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.floatingactionbutton.FloatingActionButton
import layout.Word

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main2)

        val taskFormIntent = Intent(this, MainActivity::class.java)

        val lock_gender = findViewById<ImageView>(R.id.lock_gender)
        val lock_word1 = findViewById<ImageView>(R.id.lock_word1)
        val lock_word2 = findViewById<ImageView>(R.id.lock_word2)

        val gender = findViewById<TextView>(R.id.Gender)
        gender.setOnClickListener {
            if(!lock_gender.isVisible){
                lock_gender.visibility = View.VISIBLE
            }
            else{
                lock_gender.visibility = View.INVISIBLE
            }
        }

        val word1 = findViewById<TextView>(R.id.word1)
        word1.setOnClickListener {
            if(!lock_word1.isVisible){
                lock_word1.visibility = View.VISIBLE
            }
            else{
                lock_word1.visibility = View.INVISIBLE
            }
        }


        val word2 = findViewById<TextView>(R.id.word2)
        word2.setOnClickListener {
            if(!lock_word2.isVisible){
                lock_word2.visibility = View.VISIBLE
            }
            else{
                lock_word2.visibility = View.INVISIBLE
            }
        }


        val see_list_button = findViewById<Button>(R.id.see_list_button)
        see_list_button.setOnClickListener {
            //startActivity(taskFormIntent)
            Toast.makeText(this, "afficher la liste", Toast.LENGTH_LONG).show()
        }

        val roll_button = findViewById<FloatingActionButton>(R.id.roll_button)
        roll_button.setOnClickListener {

            if(!lock_gender.isVisible){
                //choisir un genre parmi une liste prédéfinie
                gender.text = "banana"
            }

            if(!lock_word1.isVisible){
                //Faire des requetes http pour changer les mots
                word1.text = "chocolate"
            }

            if(!lock_word2.isVisible){
                //Faire des requetes http pour changer les mots
                word2.text = "milk"
            }

            Toast.makeText(this, "Yey!", Toast.LENGTH_SHORT).show()
        }

    }
}
