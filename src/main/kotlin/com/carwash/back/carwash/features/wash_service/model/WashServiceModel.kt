package com.carwash.back.carwash.features.wash_service.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "service")
data class WashServiceModel(     //TODO testes de persisntecia
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @JsonProperty("id_service")
    val idService: Long,
    val date: Date,
    val observations: String,
    val value: Double,
    val local: String,
    val paymentType: String,
    val aspire: Boolean,
    val wax: Boolean,
    val silicone: Boolean,
    val pneuLittleBack: Boolean
)


