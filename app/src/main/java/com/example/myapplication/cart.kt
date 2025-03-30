package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder.R

class cart : AppCompatActivity() {

    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var totalAmount: TextView
    private lateinit var subtotal: TextView
    private lateinit var taxAndFees: TextView
    private lateinit var delivery: TextView
    private lateinit var cartAdapter: CartAdapter
    private lateinit var backButtoncart: ImageView
    private lateinit var checkoutButton: Button  // Added checkout button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Initialize views
        cartRecyclerView = findViewById(R.id.cartList)
        totalAmount = findViewById(R.id.totalAmount)
        subtotal = findViewById(R.id.subtotal)
        taxAndFees = findViewById(R.id.taxAndFees)
        delivery = findViewById(R.id.delivery)
        backButtoncart = findViewById(R.id.backButtoncart)
        checkoutButton = findViewById(R.id.checkoutButton) // Initialize checkout button

        // Set RecyclerView Adapter and LayoutManager
        cartRecyclerView.layoutManager = LinearLayoutManager(this)
        cartAdapter = CartAdapter(CartManager.getCartItems().toMutableList()) {
            updateCartDetails()
        }
        cartRecyclerView.adapter = cartAdapter

        // Back button action
        backButtoncart.setOnClickListener {
            navigateToHomePage()
        }

        // Checkout button action
        checkoutButton.setOnClickListener {
            navigateToPaymentPage()
        }

        // Update cart details initially
        updateCartDetails()
    }

    private fun updateCartDetails() {
        val cartItems = CartManager.getCartItems()

        // Calculate subtotal, tax, and delivery
        val subtotalAmount = CartManager.getTotalPrice()
        val taxAmount = subtotalAmount * 0.10 // Example tax rate: 10%
        val deliveryFee = 5.0 // Fixed delivery fee

        // Update UI with calculated values
        subtotal.text = "Subtotal: Rs$subtotalAmount"
        taxAndFees.text = "Tax and Fees: Rs$taxAmount"
        delivery.text = "Delivery: Rs$deliveryFee"

        // Update total amount (subtotal + tax + delivery fee)
        val totalAmountValue = subtotalAmount + taxAmount + deliveryFee
        totalAmount.text = "Total: Rs$totalAmountValue"
    }

    private fun navigateToHomePage() {
        val intent = Intent(this, homepage::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToPaymentPage() {
        val intent = Intent(this, payment::class.java) // Navigate to Payment Page
        startActivity(intent)
    }
}


