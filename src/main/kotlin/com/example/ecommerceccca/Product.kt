package com.example.ecommerceccca

import kotlin.random.Random

data class Product(
    val id: Int = Random.nextInt(),
    val description: String,
    val price: Float,
    val quantity: Int = 0
) {
    companion object {
        val listOfProducts = generateRandomProducts(5)
    }
}

fun generateRandomProducts(n: Int): MutableList<Product> {
    val products = mutableListOf<Product>()
    for (i in 1..n) {
        products.add(Product(i, "Product$i", Random.nextFloat() * 10, Random.nextInt(1, 10)))
    }
    return products
}
