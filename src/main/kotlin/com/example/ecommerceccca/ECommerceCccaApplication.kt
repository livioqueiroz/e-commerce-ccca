package com.example.ecommerceccca

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ECommerceCccaApplication

fun main(args: Array<String>) {
	runApplication<ECommerceCccaApplication>(*args)
	print( "O CPF é: ${ValidateCPF().validate("77777777777")}")

}
