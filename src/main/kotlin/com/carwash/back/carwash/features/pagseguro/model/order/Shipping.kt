package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.features.address.model.AddressEntity
import com.carwash.back.carwash.utils.Constants
import com.fasterxml.jackson.annotation.JsonProperty

data class Shipping(
    @JsonProperty("address")
    val address: Address
) {
    companion object {
        val DUMB_SHIPPING = Shipping(
            address = Address.DUMB_ADDRESS
        )
        val EMPTY_SHIPPING = Shipping(
            address = Address.EMPTY_ADDRESS
        )

        fun mapShipping(address: AddressEntity) = Shipping(
            address = Address(
                street = address.street,
                number = address.number,
                complement = address.complement,
                locality = address.neighborhood,
                city = address.city,
                regionCode = address.state,
                country = Constants.COUNTRY_PREFIX,
                postalCode = address.zip
            )
        )
    }
}