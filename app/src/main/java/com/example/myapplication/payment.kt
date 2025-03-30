package com.example.myapplication

import android.os.Bundle
import android.text.InputFilter
import android.text.Spanned
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodorder.R

class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val paymentBack = findViewById<ImageView>(R.id.paymentback)
        paymentBack.setOnClickListener { finish() }

        val nameField = findViewById<EditText>(R.id.cardholder_name)
        val cardNumberField = findViewById<EditText>(R.id.card_number)
        val cvvField = findViewById<EditText>(R.id.cvv)
        val paymentMethodGroup = findViewById<RadioGroup>(R.id.payment_method_group)
        val payNowButton = findViewById<Button>(R.id.pay_now)

        // Enforce input length programmatically (optional)
        cardNumberField.filters = arrayOf(InputFilter.LengthFilter(16))
        cvvField.filters = arrayOf(InputFilter.LengthFilter(3))

        payNowButton.setOnClickListener {
            val name = nameField.text.toString().trim()
            val cardNumber = cardNumberField.text.toString().trim()
            val cvv = cvvField.text.toString().trim()
            val selectedPaymentMethod = paymentMethodGroup.checkedRadioButtonId

            if (name.isEmpty()) {
                nameField.error = "Cardholder name is required!"
                return@setOnClickListener
            }

            if (cardNumber.length != 16) {
                cardNumberField.error = "Enter a valid 16-digit card number!"
                return@setOnClickListener
            }

            if (cvv.length != 3) {
                cvvField.error = "Enter a valid 3-digit CVV!"
                return@setOnClickListener
            }

            if (selectedPaymentMethod == -1) {
                Toast.makeText(this, "Please select a payment method!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Your order is ready!", Toast.LENGTH_SHORT).show()
        }
    }
}
