package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentResponse(
    @JsonProperty("code")
    val code: String,
    @JsonProperty("message")
    val message: String,
    @JsonProperty("raw_data")
    val rawData: RawDataResponse,
    @JsonProperty("reference")
    val reference: String
)