package com.carwash.back.carwash.features.colaborator.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "colaborator_profile")
data class CollaboratorProfile(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore val idColaborator: Long,
    @JsonProperty("name") val name: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("cellphone") val cellphone: String,
    @JsonProperty("colab_rank") val colabRank: Int,
    @JsonProperty("badge_status") val badgeStatus: String,
    @JsonProperty("washes_number") val washesNumber: Int,
    @JsonProperty("password") val password: String
)