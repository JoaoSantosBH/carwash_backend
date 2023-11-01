package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class AmountXResponse(
    @JsonProperty("value")
    val value: Int
)