package com.example.horn_sample

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent
import android.widget.ImageView


class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<Button>(R.id.horn_btn)
        btn.setOnClickListener {
            Toast.makeText(applicationContext, "horn pressed", Toast.LENGTH_SHORT).show()
        }
        val profile_btn= findViewById<ImageView>(R.id.profile)
        profile_btn.setOnClickListener {
           intent=Intent(this@Home,profile::class.java)
            startActivity(intent)
        }

    }
}