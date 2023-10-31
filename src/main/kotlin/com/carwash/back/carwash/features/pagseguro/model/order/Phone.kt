package com.carwash.back.carwash.features.pagseguro.model.order


import com.fasterxml.jackson.annotation.JsonProperty

data class Phone(
    @JsonProperty("area")
    val area: String,
    @JsonProperty("country")
    val country: String,
    @JsonProperty("number")
    val number: String,
    @JsonProperty("type")
    val type: String
) {
    companion object {
        val DUMB_PHONE = Phone(
            country = "55",
            area = "11",
            number = "999999999",
            type = "MOBILE"
        )
    }
}