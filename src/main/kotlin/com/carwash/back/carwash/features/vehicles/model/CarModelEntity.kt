package com.carwash.back.carwash.features.vehicles.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "car_model")
data class CarModelEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_car_model")
    val idCarModel: Long,
    @JsonProperty("car_model_name")
    val carModelName: String,
    @JsonProperty("id_car_brand")
    val idCarBrand: Long
)