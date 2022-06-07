package com.example.digi_locker

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class ViewActivity : AppCompatActivity() {
    val REQ_CODE = 1
    var selectedFile : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val curr = AppConstants().getCurrentScreen()
        setContentView(R.layout.activity_view)
        var title = findViewById<TextView>(R.id.title)
        title.text = AppConstants().sections[curr!!]
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
            saveImageAndReload()
        }
    }
    fun saveImageAndReload(){
        findViewById<ImageView>(R.id.image1).setImageURI(selectedFile)
    }
}