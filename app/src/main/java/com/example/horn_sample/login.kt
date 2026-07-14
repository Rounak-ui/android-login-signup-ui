package com.example.horn_sample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.TextView
import android.net.Uri
import android.widget.EditText
import android.widget.ImageView


class Login : AppCompatActivity() {
    companion object {
        const val key = "con.example.horn_sample.key"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<TextView>(R.id.signup)
        btn.setOnClickListener {
            val intent = Intent(this@Login, Signup::class.java)
            startActivity(intent)
        }
        val googBtn = findViewById<ImageView>(R.id.google_login)
        googBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.google.com")
            startActivity(intent)
        }
        val appleBtn = findViewById<ImageView>(R.id.apple_login)
        appleBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.apple.com")
            startActivity(intent)
        }
        val loginBtn = findViewById<TextView>(R.id.login_btn)
        loginBtn.setOnClickListener {
            val user_email = findViewById<EditText>(R.id.edittxt_Email).text.toString()
            val intent = Intent(this@Login, profile::class.java)
            intent.putExtra(key, user_email)
            startActivity(intent)
        }
    }
}