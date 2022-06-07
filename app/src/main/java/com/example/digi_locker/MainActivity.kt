package com.example.digi_locker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

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