package com.example.myapplication

data class CartItem(val name: String, var quantity: Int, val price: Int)

object CartManager {
    private val cartItems = mutableListOf<CartItem>()

    fun addToCart(item: CartItem) {
        val existingItem = cartItems.find { it.name == item.name }
        if (existingItem != null) {
            existingItem.quantity += item.quantity
        } else {
            cartItems.add(item)
        }
    }

    fun removeFromCart(item: CartItem) {
        cartItems.remove(item)
    }

    fun getCartItems(): List<CartItem> {
        return cartItems
    }

    fun getTotalPrice(): Int {
        return cartItems.sumOf { it.quantity * it.price }
    }
}
