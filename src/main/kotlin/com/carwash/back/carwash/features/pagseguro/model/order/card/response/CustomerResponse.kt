package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class CustomerResponse(
    @JsonProperty("email")
    val email: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("phones")
    val phones: List<PhoneResponse>,
    @JsonProperty("tax_id")
    val taxId: String
)