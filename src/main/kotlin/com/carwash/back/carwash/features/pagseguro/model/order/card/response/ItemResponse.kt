package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class ItemResponse(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("quantity")
    val quantity: Int,
    @JsonProperty("reference_id")
    val referenceId: String,
    @JsonProperty("unit_amount")
    val unitAmount: Int
)