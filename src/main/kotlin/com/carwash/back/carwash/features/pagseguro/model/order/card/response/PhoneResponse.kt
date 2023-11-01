package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class PhoneResponse(
    @JsonProperty("area")
    val area: String,
    @JsonProperty("country")
    val country: String,
    @JsonProperty("number")
    val number: String,
    @JsonProperty("type")
    val type: String
)