package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class SummaryResponse(
    @JsonProperty("paid")
    val paid: Int,
    @JsonProperty("refunded")
    val refunded: Int,
    @JsonProperty("total")
    val total: Int
)