package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class LinkResponse(
    @JsonProperty("href")
    val href: String,
    @JsonProperty("media")
    val media: String,
    @JsonProperty("rel")
    val rel: String,
    @JsonProperty("type")
    val type: String
)