package com.carwash.back.carwash.features.vehicles.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "vehicle")
data class VehicleEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @JsonProperty("id_vehicle")
    val idVehicle: Long,
    @JsonProperty("id_car_brand")
    val idCarBrand: Long,
    @JsonProperty("id_car_model")
    val idCarModel: Long,
    @JsonProperty("user_id")
    val userId: Long,
    @JsonProperty("vehicle_plate")
    val vehiclePlate:String
)