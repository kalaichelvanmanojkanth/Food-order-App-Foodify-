package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.PatternsCompat
import com.example.foodorder.R

class loginpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

        val emailEditText = findViewById<EditText>(R.id.editTextText)
        val passwordEditText = findViewById<EditText>(R.id.editText)
        val loginButton = findViewById<Button>(R.id.login)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString()

            if (validateForm(email, password)) {
                // If validation succeeds, proceed to the next activity
                val intent = Intent(this, homepage::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateForm(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            showToast("Email is required")
            return false
        }

        if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Enter a valid email address")
            return false
        }

        if (password.isEmpty()) {
            showToast("Password is required")
            return false
        }

        if (password.length < 6) {
            showToast("Password must be at least 6 characters long")
            return false
        }

        return true
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
