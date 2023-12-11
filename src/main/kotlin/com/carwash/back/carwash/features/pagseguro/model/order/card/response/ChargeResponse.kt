package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class ChargeResponse(
    @JsonProperty("amount")
    val amount: AmountResponse,
    @JsonProperty("created_at")
    val createdAt: String,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("id")
    val id: String,
    @JsonProperty("links")
    val links: List<LinkResponse>,
    @JsonProperty("paid_at")
    val paidAt: String,
    @JsonProperty("payment_method")
    val paymentMethod: PaymentMethodResponse,
    @JsonProperty("payment_response")
    val paymentResponse: PaymentResponse,
    @JsonProperty("reference_id")
    val referenceId: String,
    @JsonProperty("status")
    val status: String
)