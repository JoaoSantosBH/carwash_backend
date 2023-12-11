package com.carwash.back.carwash.features.pagseguro.model.order.pix.response

import com.fasterxml.jackson.annotation.JsonProperty


data class Item(
    @JsonProperty("name")
    val name: String,
    @JsonProperty("quantity")
    val quantity: Int,
    @JsonProperty("unit_amount")
    val unitAmount: Int
)