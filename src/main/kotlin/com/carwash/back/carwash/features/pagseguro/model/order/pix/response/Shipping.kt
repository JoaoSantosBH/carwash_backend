package com.carwash.back.carwash.features.pagseguro.model.order.pix.response


import com.fasterxml.jackson.annotation.JsonProperty

data class Shipping(
    @JsonProperty("address")
    val address: Address
)