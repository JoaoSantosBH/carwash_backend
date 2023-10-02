package com.carwash.back.carwash.features.vehicles.data

import com.carwash.back.carwash.features.vehicles.model.CarBrandEntity
import com.carwash.back.carwash.features.vehicles.model.CarModelEntity
import com.carwash.back.carwash.features.vehicles.model.VehicleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface VehicleRepository : JpaRepository<VehicleEntity, Long>

interface VehicleModelRepository : JpaRepository<CarModelEntity, Long>

interface VehicleBrandRepository : JpaRepository<CarBrandEntity, Long>