package com.carwash.back.carwash.features.pagseguro.model.order

import com.fasterxml.jackson.annotation.JsonProperty


data class RawData(
    @JsonProperty("authorization_code")
    val authorizationCode: String,
    @JsonProperty("nsu")
    val nsu: String,
    @JsonProperty("reason_code")
    val reasonCode: String
)