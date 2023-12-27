package com.example.fileapp

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewImageActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_image)

        val src = intent.getStringExtra("image")

        if (src == null) {
            val noImage = findViewById<TextView>(R.id.no_image)
            noImage.visibility = View.VISIBLE
            return
        }

        val bitmap = BitmapFactory.decodeFile(src)
        val image = findViewById<ImageView>(R.id.image_view)
        image.setImageBitmap(bitmap)
    }
}