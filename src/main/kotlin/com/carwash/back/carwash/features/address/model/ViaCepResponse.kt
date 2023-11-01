package com.carwash.back.carwash.features.address.model

import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.fasterxml.jackson.annotation.JsonProperty

data class ViaCepResponse(
    @JsonProperty("cep") val zip: String? = EMPTY_STRING,
    @JsonProperty("logradouro") val street: String? = EMPTY_STRING,
    @JsonProperty("complemento") val complement: String? = EMPTY_STRING,
    @JsonProperty("bairro") val neighborhood: String? = EMPTY_STRING,
    @JsonProperty("localidade") val city: String? = EMPTY_STRING,
    @JsonProperty("uf") val state: String? = EMPTY_STRING,
) {
    companion object {
        fun ViaCepResponse.toAddress() = AddressEntity(
            idAddress = -1,
            userId = -1,
            street = this.street ?: EMPTY_STRING,
            number = EMPTY_STRING,
            complement = EMPTY_STRING,
            neighborhood = this.neighborhood ?: EMPTY_STRING,
            city = this.city ?: EMPTY_STRING,
            state = this.state ?: EMPTY_STRING,
            zip = this.zip ?: EMPTY_STRING
        )
    }
}