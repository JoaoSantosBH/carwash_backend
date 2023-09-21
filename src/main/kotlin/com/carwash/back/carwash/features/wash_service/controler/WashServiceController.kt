package com.carwash.back.carwash.features.wash_service.controler

import com.carwash.back.carwash.features.wash_service.model.WashServiceModel
import com.carwash.back.carwash.features.wash_service.service.WashServiceServices
import com.carwash.back.carwash.utils.Endpoints.ADD_SERVICE_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.GET_SERVICE_BY_ID_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class WashServiceController {

    @Autowired
    lateinit var service: WashServiceServices

    @PostMapping(ADD_SERVICE_ENDPOINT)
    fun createService(@RequestBody request: WashServiceModel): WashServiceModel? {
        return service.createService(request)
    }

    @GetMapping(ADD_SERVICE_ENDPOINT)
    fun fetchAllServices(): List<WashServiceModel?>? {
        return service.fetchAllServices()
    }

    @GetMapping(GET_SERVICE_BY_ID_ENDPOINT)
    fun fetchServiceById(@PathVariable id: Long): WashServiceModel? {
        return service.fetchServiceById(id)
    }

    @PutMapping(GET_SERVICE_BY_ID_ENDPOINT)
    fun updateServiceStatus(@RequestBody request: WashServiceModel, @PathVariable id: Long): WashServiceModel? {
        return service.updateServiceStatus(request)
    }

    @DeleteMapping(GET_SERVICE_BY_ID_ENDPOINT)
    fun deleteServiceById(@PathVariable id: Long) {
        service.deleteServiceById(id)
    }

}