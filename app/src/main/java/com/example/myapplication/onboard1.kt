package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorder.MainActivity
import com.example.foodorder.R

class onboard1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboard1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val secondActbutton = findViewById<Button>(R.id.onboard1)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this, onboard2::class.java)
            startActivity(Intent)
        }
            val secondActbutto = findViewById<Button>(R.id.onboard1back)
            secondActbutto.setOnClickListener {
                val Intent = Intent(this, MainActivity::class.java)
                startActivity(Intent)
            }
        }
    }
