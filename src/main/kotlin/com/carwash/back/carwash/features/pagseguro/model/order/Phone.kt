package com.carwash.back.carwash.features.pagseguro.model.order


import com.carwash.back.carwash.utils.Constants.EMPTY_STRING
import com.carwash.back.carwash.utils.TypePhoneEnum
import com.fasterxml.jackson.annotation.JsonProperty

data class Phone(
    @JsonProperty("area")
    val area: String,
    @JsonProperty("country")
    val country: String,
    @JsonProperty("number")
    val number: String,
    @JsonProperty("type")
    val type: String
) {
    companion object {
        val DUMB_PHONE = Phone(
            country = "55",
            area = "11",
            number = "999999999",
            type = "MOBILE"
        )
        val EMPTY_PHONE = Phone(
            country = EMPTY_STRING,
            area = EMPTY_STRING,
            number = EMPTY_STRING,
            type = TypePhoneEnum.MOBILE.type
        )
    }
}