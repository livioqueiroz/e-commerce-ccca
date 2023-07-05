package com.example.ecommerceccca

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ECommerceCccaApplicationTests {

    @Autowired
    private lateinit var validateCPF: ValidateCPF

    @Test
    fun `should validate CPF`() {
        assertTrue(validateCPF.validate("00761779477"))
        assertFalse(validateCPF.validate("25410512055"))
    }

    @Test
    fun `should create an order`() {

        val order = Order()
        order.addProduct(Product(id = 1, "P1", 1000F, 1))
        assertEquals(1000.0, order.totalAmount())
        order.addProduct(Product(id = 2, "P2", 10F, 2))
        assertEquals(1020.0, order.totalAmount())
        order.addProduct(Product(id = 3, "P3", 100F, 3))
        assertEquals(1320.0, order.totalAmount())
    }

    @Test
    fun `should create an order with discount`() {

        val order = Order()
        order.addProduct(Product(id = 1, "P1", 1000F, 1))
        order.addProduct(Product(id = 2, "P2", 100F, 2))
        order.addProduct(Product(id = 3, "P3", 100F, 3))

        order.insertCoupon("kotlin")

        assertEquals(1350.0, order.totalAmount())

    }

}

