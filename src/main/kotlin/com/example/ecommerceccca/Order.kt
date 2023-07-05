package com.example.ecommerceccca

import java.util.UUID

class Order(
    private val id: UUID = UUID.randomUUID(),
    val products: MutableList<Product> = mutableListOf(),
    private var amount: Double = 0.0,
    private val validCoupons: Map<String, Double> = mapOf("kotlin" to 0.1, "livio" to 0.2)
) {
    fun addProduct(product: Product) {
        products.add(product)
        updateAmount(product)
    }

    private fun updateAmount(product: Product) {
        amount += (product.price * product.quantity)
    }

    fun insertCoupon(coupon: String) {
        if (validCoupons.containsKey(coupon)) {
            amount -= amount * validCoupons[coupon]!!
        }
    }

    fun totalAmount() = amount
}