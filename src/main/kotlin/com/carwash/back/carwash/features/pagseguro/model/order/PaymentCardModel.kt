package com.carwash.back.carwash.features.pagseguro.model.order

import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentCardModel(
    @JsonProperty("tax_id") val taxId: String,
    @JsonProperty("holder") val holder: String,
    @JsonProperty("number") val number: String,
    @JsonProperty("exp_month") val expMonth: String,
    @JsonProperty("exp_year") val expYear: String,
    @JsonProperty("security_code") val securityCode: String,
    @JsonProperty("installments") val installments: Int
) {
}