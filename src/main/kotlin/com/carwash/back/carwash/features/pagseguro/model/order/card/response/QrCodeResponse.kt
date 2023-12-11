package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class QrCodeResponse(
    @JsonProperty("amount")
    val amount: AmountXResponse,
    @JsonProperty("arrangements")
    val arrangements: List<String>,
    @JsonProperty("expiration_date")
    val expirationDate: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("links")
    val links: List<LinkResponse>,
    @JsonProperty("text")
    val text: String
)