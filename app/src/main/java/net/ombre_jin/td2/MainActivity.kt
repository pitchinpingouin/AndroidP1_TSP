package net.ombre_jin.td2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import layout.Association
import net.ombre_jin.td2.DBViewModel.associations
import net.ombre_jin.td2.DBViewModel.genders
import okhttp3.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val associationListFormIntent = Intent(this, RecyclerViewActivity::class.java)
        //val associationListFormIntent = Intent(this, AssociationFormActivity::class.java)

        //val lockGender = findViewById<ImageView>(R.id.lock_gender)
        //val lockWord1 = findViewById<ImageView>(R.id.lock_word1)
        //val lockWord2 = findViewById<ImageView>(R.id.lock_word2)

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


        //val see_list_button = findViewById<Button>(R.id.see_list_button)
        see_list_button.setOnClickListener {
            startActivity(associationListFormIntent)
        }

        //val add_button = findViewById<Button>(R.id.add_button)
        add_button.setOnClickListener {
            associations.add(Association(associations.size, gender.text.toString(), word1.text.toString(), word2.text.toString(), ""))
            //startActivity(associationListFormIntent)
            Toast.makeText(this, "Added!", Toast.LENGTH_SHORT).show()
        }




        fun fetchJson(){
            val request = Request.Builder().
                url(API.BASE_URL_TEST).
                build()

            val client = OkHttpClient()

            client.newCall(request).enqueue(object: Callback {
                override fun onFailure(call: Call, e: java.io.IOException) {
                    println("faileddd")
                }

                override fun onResponse(call: Call, response: Response) {
                    println("suceededdddd!!!!")
                    val body = response?.body?.string()
                    println(body)

                    val gson = GsonBuilder().create()

                    val wordd = gson.fromJson(body,Wordd::class.java)

                    runOnUiThread {
                        word1.text = wordd.word
                        word2.text = wordd.word
                    }

                }
            })
        }






        fun roll(){
            fetchJson()

            if(!lock_gender.isVisible){
                //choisir un genre parmi une liste prédéfinie
                val randomIndex = (0..genders.size - 1).random()
                gender.text = genders[randomIndex]
            }

            if(!lock_word1.isVisible){
                //Faire des requetes http pour changer les mots
                //word1.text = "chocolategfhjkhhgf"


            }

            if(!lock_word2.isVisible){
                //Faire des requetes http pour changer les mots
                //word2.text = "milkfghjklkjhgfhjkj"
            }
        }

        roll_button.setOnClickListener {
            roll()
            //Toast.makeText(this, "Yey!", Toast.LENGTH_SHORT).show()
        }
    }
}

class Wordd(val id: Int, val word : String)
