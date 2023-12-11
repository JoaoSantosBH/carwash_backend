package com.carwash.back.carwash.features.pagseguro.model.order.pix.response

import com.fasterxml.jackson.annotation.JsonProperty

data class Link(
    @JsonProperty("href")
    val href: String,
    @JsonProperty("media")
    val media: String,
    @JsonProperty("rel")
    val rel: String,
    @JsonProperty("type")
    val type: String
)