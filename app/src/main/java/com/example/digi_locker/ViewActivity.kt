package com.example.digi_locker

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileOutputStream


class ViewActivity : AppCompatActivity() {
    val REQ_CODE = 1
    var selectedFile : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val curr = AppConstants().getCurrentScreen()
        setContentView(R.layout.activity_view)
        var title = findViewById<TextView>(R.id.title)
        title.text = AppConstants().sections[curr!!]

        val file: File = applicationContext.getFileStreamPath("$curr.png")
        if(file.exists()){
            val imageFullPath: String = file.getAbsolutePath()
            findViewById<ImageView>(R.id.image1).setImageURI(Uri.parse(imageFullPath))
        }else{
            findViewById<ImageView>(R.id.image1).setImageResource(R.drawable.ic_launcher_background)
        }


    }
    fun onBackPressed(view:View){
        finish()
    }
    fun onAddPressed(view:View){
        var intent = Intent();
        intent.setType("image/*")
        intent.setAction(Intent.ACTION_GET_CONTENT)
        startActivityForResult(Intent.createChooser(intent, "Select an image"), REQ_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            selectedFile = data?.data
            if(selectedFile != null){
                saveImageAndReload(selectedFile!!)
            }

        }
    }
    fun saveImageAndReload(uri: Uri){
        findViewById<ImageView>(R.id.image1).setImageURI(uri)
        val curr = AppConstants().getCurrentScreen()
        val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
        saveImage(this,bitmap, "$curr.png")
    }
    fun saveImage(context: Context, b: Bitmap, imageName: String?) {
        val foStream: FileOutputStream
        try {
            foStream = context.openFileOutput(imageName, MODE_PRIVATE)
            b.compress(Bitmap.CompressFormat.PNG, 100, foStream)
            foStream.close()
        } catch (e: Exception) {
            Toast.makeText(this,"Exception 2, Something went wrong!",Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}