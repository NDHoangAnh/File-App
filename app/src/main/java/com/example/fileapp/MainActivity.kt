package com.example.fileapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val storageBtn = findViewById<Button>(R.id.storage_btn)
        storageBtn.setOnClickListener {
            if (checkPermission()) {
                // permission allowed
                val intent = Intent(this, ListFilesActivity::class.java)
                val path = Environment.getExternalStorageDirectory().path
                intent.putExtra("path", path)
                startActivity(intent)
            } else {
                // permission not allowed
                requestPermission()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun checkPermission(): Boolean {
        return Environment.isExternalStorageManager()
    }

    private fun requestPermission() {
        val intent = Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION)
        startActivity(intent)
    }
}