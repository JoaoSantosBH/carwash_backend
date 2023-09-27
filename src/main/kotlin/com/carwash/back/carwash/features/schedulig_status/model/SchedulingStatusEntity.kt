package com.carwash.back.carwash.features.schedulig_status.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "scheduling_status")
data class SchedulingStatusEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore @JsonProperty("id_status") val idStatus: Long,
    val status: String
)
