package com.carwash.back.carwash.features.wash.controler

import com.carwash.back.carwash.features.wash.model.WashEntity
import com.carwash.back.carwash.features.wash.service.WashServices
import com.carwash.back.carwash.utils.Endpoints.ADD_SERVICE_ENDPOINT
import com.carwash.back.carwash.utils.Endpoints.GET_SERVICE_BY_ID_ENDPOINT
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class WashController {

    @Autowired
    lateinit var service: WashServices

    @PostMapping(ADD_SERVICE_ENDPOINT)
    fun createWash(@RequestBody request: WashEntity): WashEntity? {
        return service.createWash(request)
    }

    @GetMapping(ADD_SERVICE_ENDPOINT)
    fun fetchAllWashs(): List<WashEntity?>? {
        return service.fetchAllWashs()
    }

    @GetMapping(GET_SERVICE_BY_ID_ENDPOINT)
    fun fetchWashById(@PathVariable id: Long): WashEntity? {
        return service.fetchWashById(id)
    }

    @PutMapping(GET_SERVICE_BY_ID_ENDPOINT)
    fun updateWashStatus(@RequestBody request: WashEntity, @PathVariable id: Long): WashEntity? {
        return service.updateWashStatus(request, id)
    }

    @DeleteMapping(GET_SERVICE_BY_ID_ENDPOINT)
    fun deleteWashById(@PathVariable id: Long) {
        service.deleteWashById(id)
    }

}