package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class RawDataResponse(
    @JsonProperty("authorization_code")
    val authorizationCode: String,
    @JsonProperty("nsu")
    val nsu: String,
    @JsonProperty("reason_code")
    val reasonCode: String
)