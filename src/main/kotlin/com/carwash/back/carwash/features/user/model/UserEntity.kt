package com.carwash.back.carwash.features.user.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "user")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    val idUser: Long,
    val name: String,
    val email: String,
    val cellphone: String,
    val password: String,//TODO add CPF
    @JsonProperty("vehicle_id") val vehicleId: Long,
    @JsonProperty("address_id") val addressId: Long,
    @JsonProperty("user_type") val userType: Int
) {

    companion object {
        val DUMB_USER = UserEntity(
            idUser = 80,
            name = "Jonas Keylo Seixas",
            email = "jonas@keyko.org",
            cellphone = "999999999",
            password = "",
            vehicleId = 17,
            addressId = 33,
            userType = 1
        )
    }
}