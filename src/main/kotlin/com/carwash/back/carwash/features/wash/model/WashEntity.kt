package com.carwash.back.carwash.features.wash.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "wash")
data class WashEntity(     //TODO testes de persisntecia
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @JsonProperty("id_wash")
    val idWash: Long,
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


