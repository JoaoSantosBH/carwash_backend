package com.carwash.back.carwash.features.wash_service.service

import com.carwash.back.carwash.features.wash_service.data.WashServiceRepository
import com.carwash.back.carwash.features.wash_service.model.WashServiceModel
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException
import com.carwash.back.carwash.utils.errors.ItemDoesntExistsException.Companion.DOESNT_EXIST
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class WashServiceServices {

    @Autowired
    private lateinit var repository: WashServiceRepository

    fun createService(service: WashServiceModel): WashServiceModel {
        return repository.save(service)
    }

    fun fetchAllServices(): List<WashServiceModel>? {
        return repository.findAll().sortedBy { it.idService }
    }

    fun fetchServiceById(id: Long): WashServiceModel {
        return repository
            .findById(id)
            .orElseThrow { ItemDoesntExistsException(DOESNT_EXIST) }
    }

    fun updateServiceStatus(service: WashServiceModel): WashServiceModel? {
        val register = repository.findById(service.idService).getOrNull()
        return if (register != null) repository.save(service)
        else throw ItemDoesntExistsException(DOESNT_EXIST)
    }

    fun deleteServiceById(id: Long): Unit? {
        return repository.deleteById(id)
    }

}