package com.carwash.back.carwash.features.pagseguro.model.order.pix.response

import com.fasterxml.jackson.annotation.JsonProperty


data class QrCode(
    @JsonProperty("amount")
    val amount: Amount,
    @JsonProperty("arrangements")
    val arrangements: List<String>,
    @JsonProperty("expiration_date")
    val expirationDate: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("links")
    val links: List<Link>,
    @JsonProperty("text")
    val text: String
)