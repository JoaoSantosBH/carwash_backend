package com.carwash.back.carwash.features.pagseguro.model.order.card.response

import com.fasterxml.jackson.annotation.JsonProperty


data class CardResponse(
    @JsonProperty("brand")
    val brand: String,
    @JsonProperty("exp_month")
    val expMonth: String,
    @JsonProperty("exp_year")
    val expYear: String,
    @JsonProperty("first_digits")
    val firstDigits: String,
    @JsonProperty("holder")
    val holder: HolderResponse,
    @JsonProperty("last_digits")
    val lastDigits: String,
    @JsonProperty("store")
    val store: Boolean
)