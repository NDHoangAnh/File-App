package com.example.fileapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class ViewTextActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_text)

        val src = intent.getStringExtra("text")

        val text = File(src).readText()
        Log.d("debug", text)
        val image = findViewById<TextView>(R.id.view_text)
        image.text = text
    }
}