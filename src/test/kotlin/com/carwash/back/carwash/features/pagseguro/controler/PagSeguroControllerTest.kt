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
    fun `WHEN gived a diferent number fractions SHOULD return same 2 fraction numbers format `(){

        val inputType01 = 120.0
        val inputType02 = 120.021234567890
        val inputType03 = 120.33

        val expectedA = 120.01
        val expectedB = 120.02
        val expectedC = 120.33

        val resultA = prepareFraction(inputType01)
        val resultB = prepareFraction(inputType02)
        val resultC = prepareFraction(inputType03)

        assertEquals(expectedA,resultA)
        assertEquals(expectedB,resultB)
        assertEquals(expectedC,resultC)

    }

    @Test
    fun `WHEN precifiateService FOR LILTE vehicle MUST return correct value `() {
        val price = precificateService(80)
        val expectedPrice = 90
        assertEquals(expectedPrice,price)
    }
}