package com.carwash.back.carwash.features.pagseguro.model.order

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
) {
    companion object {
        val DUMB_LINK_1 = Link(
            rel = "SELF",
            href = "https://sandbox.api.pagseguro.com/orders/ORDE_76F9E52D-6E78-4624-89E8-87DB8D2843AD",
            media =  "application/json",
            type = "GET")

        val DUMB_LINK_2 = Link(
            rel = "PAY",
            href = "https://sandbox.api.pagseguro.com/orders/ORDE_76F9E52D-6E78-4624-89E8-87DB8D2843AD/pay",
            media =  "application/json",
            type = "POST")
    }
}