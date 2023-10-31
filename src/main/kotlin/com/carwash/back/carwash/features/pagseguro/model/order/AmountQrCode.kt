package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.features.pagseguro.controler.addDoubleZeroCurrency
import com.fasterxml.jackson.annotation.JsonProperty

data class AmountQrCode(
    @JsonProperty("value")
    val value: Int
) {
    companion object {
        val DUMB_AMOUNT = AmountQrCode(addDoubleZeroCurrency(90))
    }
}