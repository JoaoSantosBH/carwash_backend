package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.features.pagseguro.controler.makeAreaSeparation
import com.carwash.back.carwash.features.pagseguro.controler.makePhoneSeparation
import com.carwash.back.carwash.features.user.model.UserEntity
import com.carwash.back.carwash.utils.Constants
import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.carwash.back.carwash.utils.TypePhoneEnum
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

         fun mapCustomer(taxId: String, user: UserEntity): Customer {
            return  Customer(
                email = user.email,
                name = user.name,
                phones = listOf(
                    Phone(
                        country = Constants.COUNTRY_CODE,
                        area = makeAreaSeparation(user.cellphone),
                        number = makePhoneSeparation(user.cellphone),
                        type = TypePhoneEnum.MOBILE.type
                    )
                ),
                taxId = taxId
            )
        }
    }
}