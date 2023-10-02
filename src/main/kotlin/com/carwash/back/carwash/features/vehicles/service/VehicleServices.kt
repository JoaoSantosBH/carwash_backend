package com.carwash.back.carwash.features.vehicles.service

import com.carwash.back.carwash.features.vehicles.data.VehicleBrandRepository
import com.carwash.back.carwash.features.vehicles.data.VehicleModelRepository
import com.carwash.back.carwash.features.vehicles.data.VehicleRepository
import com.carwash.back.carwash.features.vehicles.model.CarBrandEntity
import com.carwash.back.carwash.features.vehicles.model.CarModelEntity
import com.carwash.back.carwash.features.vehicles.model.VehicleEntity
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleServices {


    @Autowired
    private lateinit var repository: VehicleRepository

    @Autowired
    private lateinit var modelRepository: VehicleModelRepository

    @Autowired
    private lateinit var brandRepository: VehicleBrandRepository

    fun fetchAllVehicles(): List<VehicleEntity>? {
        return repository.findAll().sortedBy { it.idVehicle }
    }

    fun create(vehicle: VehicleEntity): VehicleEntity? {
        return repository.save(vehicle)
    }

    fun fetchVehiclesByUserId(userId:Long) : List<VehicleEntity>? {
        return repository.findAll().filter { it.userId == userId }
    }

    fun deleteVehicleByUserId(userId: Long) {
        val register = repository.findAll().firstOrNull { it.userId == userId }
        return if (register != null) {
            repository.delete(register)
        } else throw ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
    }

    fun deleteAllVehicleByUserId(userId: Long) {
        val register = repository.findAll().filter { it.userId == userId }
        return if (register != null) {
           register.forEach { repository.delete(it) }
        } else throw ItemDoesntExistsException(ItemDoesntExistsException.DOESNT_EXIST)
    }

    fun fetchAllModels(brandId: Long): List<CarModelEntity>? {
        return modelRepository
            .findAll().filter { it.idCarBrand == brandId }
            .sortedBy {  it.carModelName }
    }

    fun fetchAllBrands(): List<CarBrandEntity>? {
       return  brandRepository.findAll().sortedBy { it.carBrandName }
    }

}