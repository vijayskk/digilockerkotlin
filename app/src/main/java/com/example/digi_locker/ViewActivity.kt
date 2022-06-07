package com.example.digi_locker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ViewActivity : AppCompatActivity() {
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
}