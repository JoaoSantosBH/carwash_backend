package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.fasterxml.jackson.annotation.JsonProperty

data class Address(
    @JsonProperty("city")
    val city: String,
    @JsonProperty("complement")
    val complement: String,
    @JsonProperty("country")
    val country: String,
    @JsonProperty("locality")
    val locality: String,
    @JsonProperty("number")
    val number: String,
    @JsonProperty("postal_code")
    val postalCode: String,
    @JsonProperty("region_code")
    val regionCode: String,
    @JsonProperty("street")
    val street: String
) {
    companion object {
        val DUMB_ADDRESS = Address(
            street = "Avenida Brigadeiro Faria Lima ",
            number = "1384",
            complement = "apto 12",
            locality = "Pinheiros",
            city = "São Paulo",
            regionCode = "SP",
            country = "BRA",
            postalCode = "01452002"
        )
        val EMPTY_ADDRESS = Address(
            street = " ",
            number = EMPTY_STRING,
            complement = EMPTY_STRING,
            locality = EMPTY_STRING,
            city = EMPTY_STRING,
            regionCode = EMPTY_STRING,
            country = EMPTY_STRING,
            postalCode = EMPTY_STRING
        )
    }


}