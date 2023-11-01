package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class AmountResponse(
    @JsonProperty("currency")
    val currency: String,
    @JsonProperty("summary")
    val summary: SummaryResponse,
    @JsonProperty("value")
    val value: Int
)