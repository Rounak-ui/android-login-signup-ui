package com.example.horn_sample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import kotlin.concurrent.timer
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val bar=findViewById<ProgressBar>(R.id.progressBar)
        bar.progress=0
        timer(initialDelay = 2000, period = 5000) {
            val intent = Intent(this@MainActivity, Login::class.java)
            startActivity(intent)
            bar.progress=bar.progress+50
            if(bar.progress==100){
                cancel()
            }

        }
    }
}