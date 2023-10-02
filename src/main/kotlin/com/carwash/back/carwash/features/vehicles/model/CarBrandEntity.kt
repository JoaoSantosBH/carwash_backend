package com.carwash.back.carwash.features.vehicles.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "car_brand")
data class CarBrandEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_car_brand")
    val idCarBrand: Long,
    @JsonProperty("car_brand_name")
    val carBrandName: String
)