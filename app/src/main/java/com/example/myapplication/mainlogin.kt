package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorder.R

class mainlogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mainlogin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val secondActbutton = findViewById<Button>(R.id.login)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this, loginpage::class.java)
            startActivity(Intent)
        }
        val secondActbutto = findViewById<Button>(R.id.signup)
        secondActbutto.setOnClickListener {
            val Intent = Intent(this,signup::class.java)
            startActivity(Intent)
        }

    }
}