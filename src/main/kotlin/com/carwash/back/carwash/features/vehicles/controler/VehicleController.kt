package com.carwash.back.carwash.features.vehicles.controler

import com.carwash.back.carwash.features.vehicles.model.CarBrandEntity
import com.carwash.back.carwash.features.vehicles.model.CarModelEntity
import com.carwash.back.carwash.features.vehicles.model.VehicleEntity
import com.carwash.back.carwash.features.vehicles.service.VehicleServices
import com.carwash.back.carwash.utils.Endpoints.MODEL_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.VEHICLE_BRANDS
import com.carwash.back.carwash.utils.Endpoints.VEHICLE_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.VEHICLE_ID_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class VehicleController {

    @Autowired
    private lateinit var service: VehicleServices


    @GetMapping(VEHICLE_ENDPOINT)
    fun fetchAllVehicles(): List<VehicleEntity>? {
        return service.fetchAllVehicles()
    }

    @PostMapping(VEHICLE_ENDPOINT)
    fun createVehicle(
        @RequestBody request: VehicleEntity
    ): VehicleEntity? {
        return service.create(request)
    }

    @GetMapping(VEHICLE_ID_ENDPOINT)
    fun fetchAllVehiclesByUserId(@PathVariable userId: Long): List<VehicleEntity>? {
        return service.fetchVehiclesByUserId(userId)
    }

    @DeleteMapping(VEHICLE_ID_ENDPOINT)
    fun deleteVehicle(@PathVariable userId: Long): ResponseEntity<*>? {
        service.deleteVehicleByUserId(userId)
        return ResponseEntity.noContent().build<Any>()
    }


    @GetMapping(MODEL_ENDPOINT)
    fun fetchAllVehicleModels(@PathVariable brandId: Long): List<CarModelEntity>? {
        return service.fetchAllModels(brandId)
    }

    @GetMapping(VEHICLE_BRANDS)
    fun fetchAllBrands(): List<CarBrandEntity>? {
        return service.fetchAllBrands()
    }

}