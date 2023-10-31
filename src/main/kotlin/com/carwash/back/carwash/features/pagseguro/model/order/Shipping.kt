package com.carwash.back.carwash.features.pagseguro.model.order


import com.fasterxml.jackson.annotation.JsonProperty

data class Shipping(
    @JsonProperty("address")
    val address: Address
) {
    companion object {
        val DUMB_SHIPPING = Shipping(
            address = Address.DUMB_ADDRESS
        )
    }
}