package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.features.pagseguro.controler.addDoubleZeroCurrency
import com.fasterxml.jackson.annotation.JsonProperty

data class Amount(
    @JsonProperty("currency")
    val currency: String,
    @JsonProperty("value")
    val value: Int
) {
    companion object {
        val DUMB_AMOUNT = Amount(
            value = addDoubleZeroCurrency(90),
            currency = "BRL"
        )
    }
}