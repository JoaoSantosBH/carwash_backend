package com.carwash.back.carwash.features.scheduling.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "scheduling")
data class SchedulingModel( //TODO rename all models to Entity
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore @JsonProperty("id_scheduling") val idScheduling: Long,
    @JsonProperty("client_id") val clientId: Long,
    @JsonProperty("colaborator_id") val colaboratorId: Long,
    @JsonProperty("service_id_service") val serviceIdService: Long,
    @JsonProperty("rank_client") val rankClient: Int,
    @JsonProperty("rank_colaborator") val rankColaborator: Int,
    @JsonProperty("id_scheduling_status") val idSchedulingStatus: Long
)