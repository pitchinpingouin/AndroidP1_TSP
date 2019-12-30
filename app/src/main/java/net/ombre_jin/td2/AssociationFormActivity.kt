package net.ombre_jin.td2
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_association_form.*
import kotlinx.coroutines.MainScope
import kotlinx.io.IOException
import layout.Association
import layout.Word
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

class AssociationFormActivity : AppCompatActivity() {

    companion object {
        const val CAMERA_PERMISSION_CODE = 1000
        const val CAMERA_REQUEST_CODE = 2001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_association_form)

        val mainActivityIntent = Intent(this, MainActivity::class.java)
        val associationReceived = intent.getParcelableExtra<Association>("AssociationToEdit")

        val backButton = findViewById<Button>(R.id.back)
        val notesImage = findViewById<ImageView>(R.id.notes_image)

        val gender_title = findViewById<TextView>(R.id.gender_title)
        val association_title = findViewById<TextView>(R.id.association)
        val description = findViewById<EditText>(R.id.description)

        if (associationReceived != null) {
            gender_title.text = (associationReceived.gender)
            association_title.text = associationReceived.word1 + " - " + associationReceived.word2
            description.setText(associationReceived.description)
        }

        notesImage.setOnClickListener {
            askCameraPermissionAndOpenCamera()
        }

        backButton.setOnClickListener {

            /*if(title.text.toString() != ""){
                if(taskReceived != null){
                    if (taskReceived.id - 1 < tasks.size) {
                        tasks[taskReceived.id - 1].word = title.text.toString()
                        tasks[taskReceived.id - 1].description = description.text.toString()
                    }
                }
                else{
                    //createActivityIntent.putExtra("newTask", Task(tasks.size, title.text.toString(), description.text.toString()))
                }
            }*/
            startActivity(mainActivityIntent)
        }
    }


    private fun askCameraPermissionAndOpenCamera() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.CAMERA
                )
            ) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE
                )
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.CAMERA),
                    CAMERA_PERMISSION_CODE
                )
                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            openCamera()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        )
            openCamera()
        else
            Toast.makeText(
                this,
                "We need access to your camera to take a picture :'(",
                Toast.LENGTH_LONG
            ).show()
    }

    private fun openCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        handlePhotoTaken(data)
    }
    private fun handlePhotoTaken(data: Intent?) {
        val image = data?.extras?.get("data") as? Bitmap
        val imageBody = imageToBody(image)

        Glide.with(this).load(image).fitCenter().into(notes_image)

        if(imageBody == null) return
    }

    // Vous pouvez ignorer cette fonction...
    private fun imageToBody(image: Bitmap?): MultipartBody.Part? {
        val f = File(cacheDir, "tmpfile.jpg")
        f.createNewFile()
        try {
            val fos = FileOutputStream(f)
            image?.compress(Bitmap.CompressFormat.PNG, 100, fos)

            fos.flush()
            fos.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val body = RequestBody.create(MediaType.parse("image/png"), f)
        return MultipartBody.Part.createFormData("avatar", f.path ,body)
    }
}
