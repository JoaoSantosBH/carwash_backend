package com.carwash.back.carwash.features.pagseguro.model.order.pix.response

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
)