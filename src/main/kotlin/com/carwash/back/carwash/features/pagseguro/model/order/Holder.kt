package com.carwash.back.carwash.features.pagseguro.model.order


import com.fasterxml.jackson.annotation.JsonProperty

data class Holder(
    @JsonProperty("name")
    val name: String
) {
    companion object {
        val DUMB_HOLDER = Holder(
            name = "José da Silva Nunes"
        )
    }
}