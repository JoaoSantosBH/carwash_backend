package com.carwash.back.carwash.features.pagseguro.model.order

import com.fasterxml.jackson.annotation.JsonProperty


data class Summary(
    @JsonProperty("paid")
    val paid: Int,
    @JsonProperty("refunded")
    val refunded: Int,
    @JsonProperty("total")
    val total: Int
)