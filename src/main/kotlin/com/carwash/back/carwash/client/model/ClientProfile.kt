package com.carwash.back.carwash.client.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Entity
@Table(name = "client_profile")
data class ClientProfile(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    val idClient: Long,
    val name: String,
    val email: String,
    val cellphone: String,
    val password:String,
)