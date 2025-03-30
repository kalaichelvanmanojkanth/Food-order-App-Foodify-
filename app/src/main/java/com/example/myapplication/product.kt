package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.foodorder.R

class product : AppCompatActivity() {

    private lateinit var quantityText: TextView
    private lateinit var productPrice: TextView
    private var quantity: Int = 1
    private val pricePerUnit = 1000
    private val productName = "Cheese Burger"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        quantityText = findViewById(R.id.quantity_text)
        productPrice = findViewById(R.id.product_price)
        val increaseQuantity: ImageView = findViewById(R.id.increase_quantity)
        val decreaseQuantity: ImageView = findViewById(R.id.decrease_quantity)
        val addToCartButton: Button = findViewById(R.id.add_to_cart_button)

        updatePrice()

        increaseQuantity.setOnClickListener {
            quantity++
            updateQuantity()
        }

        decreaseQuantity.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateQuantity()
            }
        }

        // Add to Cart Button Click
        addToCartButton.setOnClickListener {
            val item = CartItem(productName, quantity, pricePerUnit)
            CartManager.addToCart(item)

            // Navigate to Cart Page
            val intent = Intent(this, cart::class.java)
            startActivity(intent)
        }
    }



    private fun updateQuantity() {
        quantityText.text = String.format("%02d", quantity)
        updatePrice()
    }

    private fun updatePrice() {
        val totalPrice = quantity * pricePerUnit
        productPrice.text = "Rs${totalPrice}"
    }
}
