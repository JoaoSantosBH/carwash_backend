package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.fasterxml.jackson.annotation.JsonProperty

data class Card(
    @JsonProperty("exp_month")
    val expMonth: String,
    @JsonProperty("exp_year")
    val expYear: String,
    @JsonProperty("holder")
    val holder: Holder,
    @JsonProperty("number")
    val number: String,
    @JsonProperty("security_code")
    val securityCode: String,
    @JsonProperty("store")
    val store: Boolean
) {
    companion object {
        val DUMB_CARD = Card(
            number = "4111111111111111",
            expMonth = "12",
            expYear = "2026",
            securityCode = "123",
            holder = Holder.DUMB_HOLDER,
            store = false
        )
        val EMPTY_CARD = Card(
            number = EMPTY_STRING,
            expMonth = EMPTY_STRING,
            expYear = EMPTY_STRING,
            securityCode = EMPTY_STRING,
            holder = Holder(EMPTY_STRING),
            store = false
        )
    }
}