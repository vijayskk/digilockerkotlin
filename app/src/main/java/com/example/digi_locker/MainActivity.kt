package com.example.digi_locker

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




    }
    fun onButton(view:View){
        var tag : Int = (view.tag as String).toInt()
        AppConstants().setScreen(tag)
        val intent = Intent(this,ViewActivity::class.java)
        startActivity(intent)
    }
}