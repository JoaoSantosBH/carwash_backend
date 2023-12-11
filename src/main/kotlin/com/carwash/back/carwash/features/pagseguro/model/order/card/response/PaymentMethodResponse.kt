package com.carwash.back.carwash.features.pagseguro.model.order.card.response

import com.fasterxml.jackson.annotation.JsonProperty


data class PaymentMethodResponse(
    @JsonProperty("capture")
    val capture: Boolean,
    @JsonProperty("card")
    val card: CardResponse,
    @JsonProperty("installments")
    val installments: Int,
    @JsonProperty("soft_descriptor")
    val softDescriptor: String,
    @JsonProperty("type")
    val type: String
)