package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorder.R

class signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val usernameField = findViewById<EditText>(R.id.editTextText)
        val emailField = findViewById<EditText>(R.id.editTextText2)
        val passwordField = findViewById<EditText>(R.id.editText)
        val confirmPasswordField = findViewById<EditText>(R.id.editText2)
        val signupButton = findViewById<Button>(R.id.signup2)

        signupButton.setOnClickListener {
            val username = usernameField.text.toString().trim()
            val email = emailField.text.toString().trim()
            val password = passwordField.text.toString().trim()
            val confirmPassword = confirmPasswordField.text.toString().trim()

            // Validation logic
            if (username.isEmpty()) {
                usernameField.error = "Full Name is required"
                return@setOnClickListener
            }
            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailField.error = "Enter a valid email address"
                return@setOnClickListener
            }
            if (password.length < 6) {
                passwordField.error = "Password must be at least 6 characters"
                return@setOnClickListener
            }
            if (password != confirmPassword) {
                confirmPasswordField.error = "Passwords do not match"
                return@setOnClickListener
            }

            // Proceed with signup process
            Toast.makeText(this, "Signup Successful!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, loginpage::class.java)
            startActivity(intent)
        }
    }
}
