package com.example.ecommerceccca

import com.example.ecommerceccca.Product.Companion.listOfProducts
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ECommerceCccaApplication

fun main(args: Array<String>) {
    runApplication<ECommerceCccaApplication>(*args)

    println("Olá, vamos iniciar o seu pedido! Insira seu CPF:")
    val CPF = readln()
    if (!ValidateCPF().validate(CPF)) throw Exception("CPF INVÁLIDO")

    val order = Order()

    println("Qual produto você deseja comprar?")
    printList(listOfProducts)
    for (i in 1..3) {
        println("Informe o número do produto")
        val id = readln().toInt() - 1
        println("Informe a quantidade")
        val qtdd = readln().toInt()
        order.addProduct(
            Product(
                id = listOfProducts[id].id,
                description = listOfProducts[id].description,
                price = listOfProducts[id].price,
                quantity = qtdd
            )
        )
    }
    order.products.forEach { println(it) }
    println(order.totalAmount())

    println("Informe o cupom de desconto")
    val coupon = readln()
    order.insertCoupon(coupon)

    println(order.totalAmount())

}

fun printList(list: MutableList<Product>) {
    for (i in 0..list.size - 1) {
        println("${list[i].id} - ${list[i].description} - R$ ${String.format("%.2f", list[i].price)}")
    }
}