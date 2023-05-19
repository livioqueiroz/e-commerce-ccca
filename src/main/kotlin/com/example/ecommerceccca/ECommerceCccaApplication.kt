package com.example.ecommerceccca

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ECommerceCccaApplication

fun main(args: Array<String>) {
    runApplication<ECommerceCccaApplication>(*args)
    println("O CPF é: ${ValidateCPF().validate("00761779477")}")

    println("O CPF é: ${ValidateCPF().validate("11111111111")}")
    println("O CPF é: ${ValidateCPF().validate("25410512055")}")
    println("O CPF é: ${ValidateCPF().validate("2541051205")}")
    println("O CPF é: ${ValidateCPF().validate(null)}")


}
