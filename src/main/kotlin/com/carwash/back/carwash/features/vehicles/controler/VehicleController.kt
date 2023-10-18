package com.carwash.back.carwash.features.vehicles.controler

import com.carwash.back.carwash.features.vehicles.model.CarBrandEntity
import com.carwash.back.carwash.features.vehicles.model.CarModelEntity
import com.carwash.back.carwash.features.vehicles.model.VehicleEntity
import com.carwash.back.carwash.features.vehicles.service.VehicleServices
import com.carwash.back.carwash.utils.Endpoints.BRANDS_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.MODEL_ENDPOINT_PATH
import com.carwash.back.carwash.utils.Endpoints.VEHICLE_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.VEHICLE_ENDPOINT_PATH
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

    @GetMapping(VEHICLE_ENDPOINT_PATH)
    fun fetchAllVehiclesByUserId(@PathVariable userId: Long): List<VehicleEntity>? {
        return service.fetchVehiclesByUserId(userId)
    }

    @DeleteMapping(VEHICLE_ENDPOINT_PATH)
    fun deleteVehicle(@PathVariable userId: Long): ResponseEntity<*>? {
        service.deleteVehicleByUserId(userId)
        return ResponseEntity.noContent().build<Any>()
    }


    @GetMapping(MODEL_ENDPOINT_PATH)
    fun fetchAllVehicleModels(@PathVariable brandId: Long): List<CarModelEntity>? {
        return service.fetchAllModels(brandId)
    }

    @GetMapping(BRANDS_ENDPOINT)
    fun fetchAllBrands(): List<CarBrandEntity>? {
        return service.fetchAllBrands()
    }

}