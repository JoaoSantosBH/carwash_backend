package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.fasterxml.jackson.annotation.JsonProperty

data class Customer(
    @JsonProperty("email")
    val email: String,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("phones")
    val phones: List<Phone>,
    @JsonProperty("tax_id")
    val taxId: String
) {
    companion object {
        val DUMB_CUSTOMER = Customer(
            email = "c27310045178839114540@sandbox.pagseguro.com.br", // TODO replace with environment variable
            name = "José da Silva",
            phones = listOf(Phone.DUMB_PHONE),
            taxId = "00000000191"
        )
        val EMPTY_CUSTOMER = Customer(
            email = EMPTY_STRING, // TODO replace with environment variable
            name = EMPTY_STRING,
            phones = listOf(Phone.DUMB_PHONE),
            taxId = EMPTY_STRING
        )
    }
}