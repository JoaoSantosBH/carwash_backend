package com.carwash.back.carwash.features.pagseguro.controler

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PagSeguroControllerTest {
    @Test
    fun `WHEN calling method makePhoneSeparation MUST return correct number`() {
        val expectedNumber = "988776655"
        val resultNumber = makePhoneSeparation("31988776655")
        assertEquals(expectedNumber, resultNumber)
    }

    @Test
    fun `WHEN calling method makeAreaSeparation MUST return correct number`() {
        val expectedNumber = "31"
        val resultNumber = makeAreaSeparation("31988776655")
        assertEquals(expectedNumber, resultNumber)
    }


    @Test
    fun `WHEN precifiateService FOR LILTE vehicle MUST return correct value `() {
        val price = PagSeguroController().precifiateService(80)
        val expectedPrice = 90
        assertEquals(expectedPrice,price)
    }
}