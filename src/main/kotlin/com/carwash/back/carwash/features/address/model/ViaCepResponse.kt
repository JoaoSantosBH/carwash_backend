package com.carwash.back.carwash.features.address.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ViaCepResponse(
    @JsonProperty("cep") val zip: String? = "",
    @JsonProperty("logradouro") val street: String? = "",
    @JsonProperty("complemento") val complement: String? = "",
    @JsonProperty("bairro") val neighborhood: String? = "",
    @JsonProperty("localidade") val city: String? = "",
    @JsonProperty("uf") val state: String? = "",
) {
    companion object {
        fun ViaCepResponse.toAddress() = AddressEntity(
            idAddress = -1,
            userId = -1,
            street = this.street ?: "",
            number = "",
            complement = "",
            neighborhood = this.neighborhood ?: "",
            city = this.city ?: "",
            state = this.state ?: "",
            zip = this.zip ?: ""
        )
    }
}