package com.carwash.back.carwash.features.pagseguro.model.order


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
            number = "",
            complement = "",
            locality = "",
            city = "",
            regionCode = "",
            country = "",
            postalCode = ""
        )
    }


}