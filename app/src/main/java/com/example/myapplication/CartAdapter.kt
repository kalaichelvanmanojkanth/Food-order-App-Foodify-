package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorder.R

class CartAdapter(private val cartItems: MutableList<CartItem>, private val onItemRemoved: () -> Unit) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val productName: TextView = view.findViewById(R.id.item_name)
        val productPrice: TextView = view.findViewById(R.id.item_price)
        val productQuantity: TextView = view.findViewById(R.id.item_quantity)
        val removeButton: Button = view.findViewById(R.id.remove_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.productName.text = item.name
        holder.productQuantity.text = "Qty: ${item.quantity}"
        holder.productPrice.text = "Rs${item.quantity * item.price}"

        // Remove Item from Cart
        holder.removeButton.setOnClickListener {
            cartItems.removeAt(position)
            notifyDataSetChanged()
            onItemRemoved()
        }
    }

    override fun getItemCount(): Int = cartItems.size
}
