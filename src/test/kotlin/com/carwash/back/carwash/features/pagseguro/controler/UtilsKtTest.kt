package com.carwash.back.carwash.features.pagseguro.controler

import com.carwash.back.carwash.features.scheduling.model.SchedulingEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UtilsKtTest {


    @Test
    fun `WHEN calling method makeReferenceId MUST return correct prefix id`() {
        val expectedId = "CWASH_ORD_CL:33_VEND:91_SCHED:3_WASH:34"
        val resultId = makeReferenceId(SchedulingEntity.DUMB_SCHEDULE)
        assertEquals(expectedId, resultId)
    }
    @Test
    fun `WHEN calling method addDoubleZeroCurrency MUST return correct value`() {
        val expectedValue = 1200
        val resultValue = addDoubleZeroCurrency(12)
        assertEquals(expectedValue, resultValue)
    }
    @Test
    fun `WHEN calling method addDoubleZeroCurrency with broken values MUST return correct value`() {
        val normalValue = 12.34
        val expectedValue = 1234
        val resultValue = normalValue.addDoubleZeroCurrency()
        assertEquals(expectedValue, resultValue)
    }
    @Test
    fun `WHEN calling method makeFakeRequest MUST return correct value`() {
        val expectedValue = 2000
        val resultRequest = makeFakeRequest(SchedulingEntity.DUMB_SCHEDULE, expectedValue/100)
        assertEquals(expectedValue, resultRequest.charges[0].amount.value)
        assertEquals(expectedValue, resultRequest.qrCodes[0].amount[0].value)
        assertEquals(expectedValue, resultRequest.items[0].unitAmount)


    }
}