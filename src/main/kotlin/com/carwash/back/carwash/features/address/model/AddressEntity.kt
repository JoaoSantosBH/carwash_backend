package com.carwash.back.carwash.features.address.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "user_address")
data class AddressEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @JsonProperty("id_address") val idAddress: Long,
    @Column(name = "user_id") val userId: Long,
    @Column(name = "logradouro") val street: String,
    @Column(name = "numero") val number: String,
    @Column(name = "complemento") val complement: String,
    @Column(name = "bairro") val neighborhood: String,
    @Column(name = "cidade") val city: String,
    @Column(name = "estado") val state: String,
    @Column(name = "cep") val zip: String
)