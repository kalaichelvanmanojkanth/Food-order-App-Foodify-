package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorder.R

class homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepage)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val linearLayout = findViewById<LinearLayout>(R.id.first) // Replace with your LinearLayout's ID
        linearLayout.setOnClickListener {
            val intent = Intent(this,product::class.java) // Ensure 'Homepage' starts with an uppercase letter as per Kotlin naming conventions
            startActivity(intent)
        }

        val linearLayou = findViewById<LinearLayout>(R.id.track1) // Replace with your LinearLayout's ID
        linearLayou.setOnClickListener {
            val intent = Intent(this,track::class.java) // Ensure 'Homepage' starts with an uppercase letter as per Kotlin naming conventions
            startActivity(intent)
        }

        val linearLayo = findViewById<LinearLayout>(R.id.cart) // Replace with your LinearLayout's ID
        linearLayo.setOnClickListener {
            val intent = Intent(this, cart::class.java) // Ensure 'Homepage' starts with an uppercase letter as per Kotlin naming conventions
            startActivity(intent)
        }

        val linearLay = findViewById<LinearLayout>(R.id.profile) // Replace with your LinearLayout's ID
        linearLay.setOnClickListener {
            val intent = Intent(this, profile::class.java) // Ensure 'Homepage' starts with an uppercase letter as per Kotlin naming conventions
            startActivity(intent)
        }






    }
}