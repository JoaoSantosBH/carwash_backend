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
    val password: String,
    @JsonProperty("vehicle_id") val vehicleId: Long,
    @JsonProperty("address_id") val addressId: Long,
    @JsonProperty("user_type") val userType: Int
)