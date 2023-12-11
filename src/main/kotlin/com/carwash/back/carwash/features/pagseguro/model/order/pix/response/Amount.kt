package com.carwash.back.carwash.features.pagseguro.model.order.pix.response


import com.fasterxml.jackson.annotation.JsonProperty

data class Amount(
    @JsonProperty("value")
    val value: Int
)