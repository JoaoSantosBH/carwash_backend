package com.carwash.back.carwash.features.scheduling.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "scheduling")
data class SchedulingEntity( //TODO rename all models to Entity
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore @JsonProperty("id_scheduling") val idScheduling: Long,
    @JsonProperty("client_id") val clientId: Long,
    @JsonProperty("executor_id") val executorId: Long,
    @JsonProperty("wash_id") val washId: Long,
    @JsonProperty("rank_client") val rankClient: Int,
    @JsonProperty("rank_executor") val rankExecutor: Int,
    @JsonProperty("status_id") val statusId: Long
) {
    companion object {
        val DUMB_SCHEDULE = SchedulingEntity(
            3, 33, 91, 34, 2, 3, 12
        )
    }
}