package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class AddressResponse(
    @JsonProperty("city")
    val city: String,
    @JsonProperty("complement")
    val complement: String,
    @JsonProperty("country")
    val country: String,
    @JsonProperty("locality")
    val locality: String,
    @JsonProperty("number")
    val number: String,
    @JsonProperty("postal_code")
    val postalCode: String,
    @JsonProperty("region_code")
    val regionCode: String,
    @JsonProperty("street")
    val street: String
)