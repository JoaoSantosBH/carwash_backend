package com.carwash.back.carwash.features.pagseguro.model.order.pix.response

import com.fasterxml.jackson.annotation.JsonProperty

data class Customer(
    @JsonProperty("email")
    val email: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("phones")
    val phones: List<Phone>,
    @JsonProperty("tax_id")
    val taxId: String
)