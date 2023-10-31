package com.carwash.back.carwash.features.pagseguro.model.order


import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentMethod(
    @JsonProperty("capture")
    val capture: Boolean,
    @JsonProperty("card")
    val card: Card,
    @JsonProperty("installments")
    val installments: Int,
    @JsonProperty("type")
    val type: String
) {
    companion object {
        val DUMB_PAYMENT_METHOD = PaymentMethod(
            type = "CREDIT_CARD",
            card = Card.DUMB_CARD,
            installments = 1,
            capture = true,
        )
    }
}