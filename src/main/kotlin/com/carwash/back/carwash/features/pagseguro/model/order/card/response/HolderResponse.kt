package com.carwash.back.carwash.features.pagseguro.model.order.card.response


import com.fasterxml.jackson.annotation.JsonProperty

data class HolderResponse(
    @JsonProperty("name")
    val name: String
)